package com.example.demo.model.persist.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;

    @Autowired
    public UserDaoImpl(PasswordEncoder passwordEncoder, JwtUtils jwtUtils, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity saveUser(UserDto userDto) {
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
        return userRepository.save(user);
    }

    public UserEntity getUser(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
        return user;
    }

    @Override
    public void deleteUserByID(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserEntity updateUser(UserDto userDto) {
        UserEntity savedUser = userRepository.findById(userDto.id()).orElseThrow(() -> new AppException("Could not find original user", HttpStatus.NOT_FOUND));
        savedUser.setActive(userDto.active());
        savedUser.setPassword(passwordEncoder.encode(userDto.password()));
        savedUser.setUsername(userDto.username());
        return savedUser;
    }


}