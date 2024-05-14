package com.example.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.business.GestorCompra;
import com.example.demo.model.entity.Compra;
import com.example.demo.model.entity.Producto;
import com.example.demo.model.entity.Usuario;

@RestController
public class ControladorCompra {
	@Autowired
	private GestorCompra gc;
	
	@PostMapping(path = "Compra", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Compra> altaCompra(@RequestBody Compra c) {
		try {
			c = gc.anadirCompra(c);
			if (c != null)
				return new ResponseEntity<Compra>(c, HttpStatus.CREATED);
			else
				return new ResponseEntity<Compra>(HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			return new ResponseEntity<Compra>(c, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "Compra/{usuario}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Producto>> buscarProductos(@PathVariable("usuario") Usuario usuario) {
		try {
			List<Producto> paux = null;
			if(usuario != null) {
				paux = gc.listarCompras(usuario);
				return new ResponseEntity<List<Producto>>(paux, HttpStatus.OK);
			} else {
				paux = null;
				return new ResponseEntity<List<Producto>>(HttpStatus.NOT_FOUND);
			}
		} catch(Exception e) {
			return new ResponseEntity<List<Producto>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "Compra/{id_usuario}/{id_producto}")
	public ResponseEntity<Producto> buscarCompra(@PathVariable("id_usuario") long id_usuario, 
			@PathVariable("id_producto") long id_producto, @RequestBody Compra c) {
		try {
			Producto paux = gc.buscarCompra(c);
			if (paux == null)
				return new ResponseEntity<Producto>(HttpStatus.BAD_REQUEST);
			else
				return new ResponseEntity<Producto>(paux, HttpStatus.OK);
			
		} catch (Exception e) {
		return new ResponseEntity<Producto>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
}
