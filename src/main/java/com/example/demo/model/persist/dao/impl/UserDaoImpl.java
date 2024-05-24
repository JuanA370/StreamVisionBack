package com.example.demo.model.persist.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.exceptions.AppException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entities.ERole;
import com.example.demo.model.entities.RoleEntity;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.persist.dao.UserDao;
import com.example.demo.model.persist.repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class UserDaoImpl implements UserDao {

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
    private UserRepository userRep;
    
    @Override
    public UserEntity createUser(UserDto userDto) {
    	
        RoleEntity role = RoleEntity.builder()
                .name(ERole.valueOf("USER"))
                .build();
        
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(role);
        
        UserEntity user = UserEntity.builder()
                .username(userDto.username())
                .password(passwordEncoder.encode(userDto.password()))
                .email(userDto.email())
                .coins(100)
                .active(true)
                .roles(roles)
                .build();
        
        UserEntity createdUser = userRep.save(user);
        return createdUser;
    }

    public UserEntity readUserById(Long id) {
    	
        UserEntity user = userRep.findById(id)
        		.orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
        return user;
    }

    @Override
    public void deleteUserById(Long userId) {
    	
    	userRep.findById(userId).orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
    	userRep.deleteById(userId);
    }

    @Override
    public UserEntity updateUser(UserDto userDto) {
    	
        UserEntity savedUser = userRep.findById(userDto.id())
        		.orElseThrow(() -> new AppException("Could not find original user", HttpStatus.NOT_FOUND));
        savedUser.setActive(userDto.active());
        savedUser.setPassword(passwordEncoder.encode(userDto.password()));
        savedUser.setUsername(userDto.username());
        
        UserEntity updatedUser = userRep.save(savedUser);
        return updatedUser;
    }


}