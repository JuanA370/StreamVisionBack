package com.example.demo.model.persist.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.catalina.User;
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
import com.example.demo.security.jwt.JwtUtils;

import jakarta.validation.Valid;

@Service
public class UserDaoImpl implements UserDao {

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
    private UserRepository userRep;
	
	@Autowired
	private JwtUtils jwtUtils;
    
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
    
    @Override
    public UserEntity readUserByToken(String token) {
    	token= token.substring(7);
    	Long id = jwtUtils.getUserIdFromToken(token);
        UserEntity user = userRep.findById(id)
        		.orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
        
        return user;
    }
    
    @Override
    public UserEntity readUserById(Long userId) {
    	UserEntity user = userRep.findById(userId)
        		.orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
        return user;
    }

    @Override
    public UserEntity deleteUserByToken(String token) {
    	token= token.substring(7);
    	Long userId = jwtUtils.getUserIdFromToken(token);
    	UserEntity savedUser = userRep.findById(userId).orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
    	savedUser.setActive(false);
    	return userRep.save(savedUser);
    }

    @Override
    public UserEntity deleteUserById(Long userId) {

    	UserEntity savedUser = userRep.findById(userId).orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
    	savedUser.setActive(false);
    	return userRep.save(savedUser);
    }
    
    @Override
    public List<UserEntity> readAllUsers(){
    	List<UserEntity> savedUsers = userRep.findAll();
    	return savedUsers;
    }
    
    @Override
    public UserEntity updateUser(UserDto userDto, String token) {
    	token = token.substring(7);
    	String password;
    	Long userID = jwtUtils.getUserIdFromToken(token);
        UserEntity savedUser = userRep.findById(userID)
        		.orElseThrow( () -> new AppException("Could not find original user", HttpStatus.NOT_FOUND));
        if (userDto.password().isBlank() || userDto.password().isEmpty())
        	password = savedUser.getPassword();
        else
        	password = passwordEncoder.encode(userDto.password());
        savedUser = UserEntity.builder()
        		.id(savedUser.getId())
        		.username(userDto.username())
                .password(password)
                .email(userDto.email())
                .coins(savedUser.getCoins())
                .active(savedUser.isActive())
                .roles(savedUser.getRoles())
                .build();
        
        
        UserEntity updatedUser = userRep.save(savedUser);
        return updatedUser;
    }


}