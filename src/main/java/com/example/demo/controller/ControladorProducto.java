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

import com.example.demo.model.entities.Product;
import com.example.demo.model.services.ProductsService;

@RestController
public class ControladorProducto {
	/*
	@Autowired
	private ProductsService gp;

	@PostMapping(path = "producto",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> altaProducto(@RequestBody Product p) {
		try {
			p = gp.saveProduct(p);
			if (p != null)
				return new ResponseEntity<Product>(p, HttpStatus.CREATED);
			else
				return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Product>(p, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(path = "producto/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> buscarProducto(@PathVariable("id") int id) {
		try {
			Product p = gp.searchProduct(id);
			if (p == null) {
				return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<Product>(p, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@PutMapping(path = "producto/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> actualizarProducto(@PathVariable("id") int id,@RequestBody Product p) {
		try {
			p.setId_producto(id);
			p = gp.saveProduct(p);
			if (p != null)
				return new ResponseEntity<Product>(p, HttpStatus.OK);
			else
				return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Product>(p, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	@DeleteMapping(path = "producto/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> eliminarProducto(@PathVariable("id") int id) {
		try {
			Product p = gp.searchProduct(id);
			if (p == null) {
				return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
			} else {
				gp.deleteProduct(p);
				return new ResponseEntity<Product>(HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	*/
}
