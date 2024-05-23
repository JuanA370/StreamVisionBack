package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.AppException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.dto.UserLoginDto;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.persist.dao.UserDao;
import com.example.demo.security.jwt.JwtUtils;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/users")
public class UserRestController {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private JwtUtils jwtUtils;


	@GetMapping("/login")
	public void login(@RequestBody UserLoginDto user) {
	}
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			UserEntity createdUser = userDao.createUser(userDto);
			responseContent.put("result", createdUser);
			httpStatus = HttpStatus.CREATED;
		} catch (Exception e) {
			responseContent.put("message", e);
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}
	
	
	
	@GetMapping(path = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> searchUser(@PathVariable("id") Long id) {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			UserEntity user = userDao.readUserById(id);
			responseContent.put("result", user);
			httpStatus = HttpStatus.OK;
		} catch (AppException e) {
			responseContent.put("message", e.getMessage());
			httpStatus = e.getHttpStatus();
		} catch (Exception e) {
			responseContent.put("message", e.getMessage());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateUser(@RequestBody UserDto userDto) {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			UserEntity updatedUser = userDao.updateUser(userDto);
			responseContent.put("result", updatedUser);
			httpStatus = HttpStatus.CREATED;
		} catch (AppException e) {
			responseContent.put("message", e.getMessage());
			httpStatus = e.getHttpStatus();
		} catch (Exception e) {
			responseContent.put("message", "Error while updating user: ".concat(e.getMessage()));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;

	}

	@DeleteMapping(path = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			userDao.deleteUserById(id);
			responseContent.put("message", "User deleted");
			httpStatus = HttpStatus.OK;
		} catch (AppException e) {
			responseContent.put("message", e.getMessage());
			httpStatus = e.getHttpStatus();
		} catch (Exception e) {
			responseContent.put("message", "Error while deleting user ".concat(e.getMessage()));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}

}
