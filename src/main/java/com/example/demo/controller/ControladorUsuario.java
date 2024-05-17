package com.example.demo.controller;

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

import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.service.UsersService;

@RestController
public class ControladorUsuario {
	
	@Autowired
	private UsersService gu;
	
	@PostMapping(path = "usuario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> altaUsuario(@RequestBody UserEntity u) {
		try {
			u = gu.saveUser(u);
			if (u != null)
				return new ResponseEntity<UserEntity>(u, HttpStatus.CREATED);
			
			else
				return new ResponseEntity<UserEntity>(HttpStatus.BAD_REQUEST);
			
		} catch (Exception e) {
			return new ResponseEntity<UserEntity>(u, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}

	}
	
	@GetMapping(path = "usuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserEntity> buscarUsuario(@PathVariable("id") int id) {
		try {
			UserEntity u = gu.searchUser(id);
			
			if (u == null) {
				return new ResponseEntity<UserEntity>(HttpStatus.NOT_FOUND);
				
			} else {
				return new ResponseEntity<UserEntity>(u, HttpStatus.OK);
				
			}
			
		} catch (Exception e) {
			return new ResponseEntity<UserEntity>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}

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
