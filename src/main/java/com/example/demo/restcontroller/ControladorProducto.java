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

import com.example.demo.model.business.GestorProducto;
import com.example.demo.model.entity.Producto;

@RestController
public class ControladorProducto {

	@Autowired
	private GestorProducto gp;

	@PostMapping(path = "producto", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> altaProducto(@RequestBody Producto p) {
		try {
			p = gp.crearActualizarProducto(p);
			if (p != null)
				return new ResponseEntity<Producto>(p, HttpStatus.CREATED);
			else
				return new ResponseEntity<Producto>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Producto>(p, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(path = "producto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> buscarProducto(@PathVariable("id") int id) {
		try {
			Producto p = gp.buscarProducto(id);
			if (p == null) {
				return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<Producto>(p, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<Producto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@PutMapping(path = "producto/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> actualizarProducto(@PathVariable("id") int id,@RequestBody Producto p) {
		try {
			p.setId_producto(id);
			p = gp.crearActualizarProducto(p);
			if (p != null)
				return new ResponseEntity<Producto>(p, HttpStatus.OK);
			else
				return new ResponseEntity<Producto>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Producto>(p, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@DeleteMapping(path = "producto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Producto> eliminarProducto(@PathVariable("id") int id) {
		try {
			Producto p = gp.buscarProducto(id);
			if (p == null) {
				return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
			} else {
				gp.eliminarProducto(p);
				return new ResponseEntity<Producto>(HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<Producto>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
