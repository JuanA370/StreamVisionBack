package com.example.demo.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.AppException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entities.ERole;
import com.example.demo.model.entities.Favorite;
import com.example.demo.model.entities.RoleEntity;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.persist.dao.impl.UserDaoImpl;
import com.example.demo.model.persist.repository.UserRepository;
import com.example.demo.model.service.UsersService;


@RestController
public class ControladorUsuario {
	
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	@PostMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createUser(@RequestBody UserDto u) {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			UserEntity user = userDaoImpl.saveUser(u);
			responseContent.put("result", u);
			httpStatus = HttpStatus.CREATED;
		} catch (Exception e) {
			responseContent.put("message", e);
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}
	
	@GetMapping(path = "usuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> buscarUsuario(@PathVariable("id") Long id) {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		try {
			UserEntity user = userDaoImpl.getUser(id);
			responseContent.put("result", user);
			httpStatus = HttpStatus.OK;
		} catch (AppException e) {
			responseContent.put("message", e.getMessage());
			httpStatus = e.getHttpStatus();
		}
		catch (Exception e) {
			responseContent.put("message", e.getMessage());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	
		} 
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}
	
	@PutMapping(path = "usuario/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> actualizarUsuario(@PathVariable("id") int id,@RequestBody UserEntity u) {
		try {
			u.setId_usuario(id);
			u = gu.saveUser(u);
			
			if (u != null)
				return new ResponseEntity<UserEntity>(u, HttpStatus.OK);
			
			else
				return new ResponseEntity<UserEntity>(HttpStatus.BAD_REQUEST);
			
		} catch (Exception e) {
			return new ResponseEntity<UserEntity>(u, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}

	}
	
	@DeleteMapping(path = "usuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> eliminarUsuario(@PathVariable("id") int id) {
		try {
			UserEntity u = gu.searchUser(id);
			if (u == null) {
				return new ResponseEntity<UserEntity>(HttpStatus.NOT_FOUND);
				
			} else {
				gu.eliminarUsuario(u);
				return new ResponseEntity<UserEntity>(HttpStatus.OK);
				
			}
			
		} catch (Exception e) {
			return new ResponseEntity<UserEntity>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}

	}

}
