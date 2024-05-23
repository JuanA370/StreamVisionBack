package com.example.demo.model.persist.dao;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entities.UserEntity;

public interface UserDao {

	public UserEntity saveUser(UserDto u);
	
	public UserEntity getUser(Long i);

	void deleteUserByID(Long id);

	UserEntity updateUser(UserDto userDto);
}
