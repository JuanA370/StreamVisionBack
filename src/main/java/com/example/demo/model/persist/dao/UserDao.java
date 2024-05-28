package com.example.demo.model.persist.dao;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entities.UserEntity;

public interface UserDao {

	public UserEntity createUser(UserDto userDto);
	
	public UserEntity readUserByToken(String token);

	public UserEntity deleteUserByToken(String token);
	
	public UserEntity deleteUserById(Long id);

	UserEntity updateUser(UserDto userDto, String token);
	
	public UserEntity readUserById(Long userId);

}
