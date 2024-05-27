package com.example.demo.model.persist.dao;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entities.UserEntity;

public interface UserDao {

	public UserEntity createUser(UserDto userDto);
	
	public UserEntity readUserById(String token);

	UserEntity deleteUserById(String token);

	UserEntity updateUser(UserDto userDto, String token);
	

}
