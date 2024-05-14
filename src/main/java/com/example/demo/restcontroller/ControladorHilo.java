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

import com.example.demo.model.business.GestorHilo;
import com.example.demo.model.entity.Hilo;

@RestController
public class ControladorHilo {
	
	@Autowired
	private GestorHilo gh;
	
	@PostMapping(path = "hilo", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hilo> altaHilo(@RequestBody Hilo h) {
		try {
			h = gh.crearActualizarHilo(h);
			if (h != null)
				return new ResponseEntity<Hilo>(h, HttpStatus.CREATED);
			else
				return new ResponseEntity<Hilo>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Hilo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "hilo/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hilo> buscarHilo(@PathVariable("id") int id, @RequestBody Hilo h) {
		try {
			h = gh.buscarHilo(id);
			if (h == null)
				return new ResponseEntity<Hilo>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<Hilo>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Hilo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "hilo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hilo> actualizarHilo(@PathVariable("id") int id, @RequestBody Hilo h) {
		try {
			h.setId_hilo(id);
			h = gh.crearActualizarHilo(h);
			if (h != null)
				return new ResponseEntity<Hilo>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<Hilo>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Hilo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path = "hilo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hilo> eliminarHilo(@PathVariable("id") int id) {
		try {
			Hilo h = gh.buscarHilo(id);
			if (h == null)
				return new ResponseEntity<Hilo>(HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<Hilo>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Hilo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
