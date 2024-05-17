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

import com.example.demo.model.entities.Thread;
import com.example.demo.model.service.ThreadsServices;

@RestController
public class ControladorHilo {
	
	@Autowired
	private ThreadsServices gh;
	
	@PostMapping(path = "hilo", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Thread> altaHilo(@RequestBody Thread h) {
		try {
			h = gh.saveThread(h);
			if (h != null)
				return new ResponseEntity<Thread>(h, HttpStatus.CREATED);
			else
				return new ResponseEntity<Thread>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Thread>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "hilo/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Thread> buscarHilo(@PathVariable("id") int id, @RequestBody Thread h) {
		try {
			h = gh.searchThread(h.getIdHilo().getId_producto().getId_producto(), h.getIdHilo().getId_hilo());
			if (h == null)
				return new ResponseEntity<Thread>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<Thread>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Thread>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path = "hilo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Thread> eliminarHilo(@PathVariable("id") Thread h) {
		try {
			h = gh.searchThread(h.getIdHilo().getId_producto().getId_producto(), h.getIdHilo().getId_hilo());
			if (h == null)
				return new ResponseEntity<Thread>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<Thread>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Thread>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
