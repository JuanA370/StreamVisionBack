package com.example.demo.restcontroller;

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

import com.example.demo.model.business.GestorUsuario;
import com.example.demo.model.entity.Usuario;

@RestController
public class ControladorUsuario {
	
	@Autowired
	private GestorUsuario gu;
	
	@PostMapping(path = "usuario", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> altaUsuario(@RequestBody Usuario u) {
		try {
			u = gu.crearActualizarUsuario(u);
			if (u != null)
				return new ResponseEntity<Usuario>(u, HttpStatus.CREATED);
			
			else
				return new ResponseEntity<Usuario>(HttpStatus.BAD_REQUEST);
			
		} catch (Exception e) {
			return new ResponseEntity<Usuario>(u, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}

	}
	
	@GetMapping(path = "usuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> buscarUsuario(@PathVariable("id") int id) {
		try {
			Usuario u = gu.buscarUsuario(id);
			
			if (u == null) {
				return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
				
			} else {
				return new ResponseEntity<Usuario>(u, HttpStatus.OK);
				
			}
			
		} catch (Exception e) {
			return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}

	}
	
	@PutMapping(path = "usuario/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> actualizarUsuario(@PathVariable("id") int id,@RequestBody Usuario u) {
		try {
			u.setId_usuario(id);
			u = gu.crearActualizarUsuario(u);
			
			if (u != null)
				return new ResponseEntity<Usuario>(u, HttpStatus.OK);
			
			else
				return new ResponseEntity<Usuario>(HttpStatus.BAD_REQUEST);
			
		} catch (Exception e) {
			return new ResponseEntity<Usuario>(u, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}

	}
	
	@DeleteMapping(path = "usuario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> eliminarUsuario(@PathVariable("id") int id) {
		try {
			Usuario u = gu.buscarUsuario(id);
			if (u == null) {
				return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
				
			} else {
				gu.eliminarUsuario(u);
				return new ResponseEntity<Usuario>(HttpStatus.OK);
				
			}
			
		} catch (Exception e) {
			return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}

	}

}
