package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.dto.UserLoginDto;
import com.example.demo.model.dto.UserResponseDto;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.persist.dao.UserDao;
import com.example.demo.service.UserDtoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@Tag(name = "Endpoint Usuarios")
public class UserRestController {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserDtoService userDtoService;

	@Operation(summary = "Inicio de sesion y creacion del token a traves de JWT")
	@GetMapping("/login")
	public void login(@RequestBody UserLoginDto user) {
	}

	@Operation(summary = "Creacion de un usuario")
	@PostMapping
	public ResponseEntity<?> createUser(@Valid @RequestBody UserDto userDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			Map<String, Object> responseContent = new HashMap<>();
			bindingResult.getFieldErrors()
					.forEach(fieldError -> responseContent.put(fieldError.getField(), fieldError.getDefaultMessage()));
			return new ResponseEntity<>(responseContent, HttpStatus.BAD_REQUEST);
		}
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			UserEntity createdUser = userDao.createUser(userDto);
			responseContent.put("result", createdUser);
			httpStatus = HttpStatus.CREATED;
		} catch (Exception e) {
			responseContent.put("message", e.getMessage());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}

	@Operation(summary = "Obtencion de los datos de un usuario a traves del token")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> searchUser(@RequestHeader("Authorization") String token) {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			UserEntity user = userDao.readUserByToken(token);
			UserResponseDto userDto = userDtoService.createUserResponseDto(user);
			responseContent.put("result", userDto);
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			responseContent.put("messager", e.getMessage());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}

	@Operation(summary = "Edicion de los datos de un usuario a traves del token")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateUser(@RequestBody UserDto userDto, @RequestHeader("Authorization") String token) {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			UserEntity updatedUser = userDao.updateUser(userDto, token);
			UserResponseDto updatedUserDto = userDtoService.createUserResponseDto(updatedUser);
			responseContent.put("result", updatedUserDto);
			httpStatus = HttpStatus.CREATED;
		} catch (Exception e) {
			responseContent.put("message", "Error while updating user: ".concat(e.getMessage()));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;

	}

	@Operation(summary = "Desactivacion de un usuario a traves del token")
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteUser(@RequestHeader("Authorization") String token) {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			UserEntity deletedUser = userDao.deleteUserByToken(token);
			responseContent.put("message",
					"User " + deletedUser.getUsername() + " with id " + deletedUser.getId() + " has been deleted");
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			responseContent.put("message", "Error while deleting user ".concat(e.getMessage()));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}

}