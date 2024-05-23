package com.example.demo.model.persist.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.AppException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entities.ERole;
import com.example.demo.model.entities.RoleEntity;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.persist.dao.UserDao;
import com.example.demo.model.persist.repository.UserRepository;

@Service
public class UserDaoImpl implements UserDao{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserEntity saveUser(UserDto userDto) {
		RoleEntity role = RoleEntity.builder()
				.name(ERole.valueOf("USER"))
				.build();
		Set<RoleEntity> roles = new HashSet<>();
		roles.add(role);
		UserEntity user=  UserEntity.builder()
				.username(userDto.username())
				.password(userDto.password())
				.email(userDto.email())
				.coins(100)
				.active(true)
				.roles(roles)
				.build();
		return userRepository.save(user);
	}
	
	public UserEntity getUser(Long i) {
		UserEntity user = userRepository.findById(i) .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
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
		savedUser.setPassword(userDto.password());
		savedUser.setUsername(userDto.username());
		return savedUser;
	}
}
