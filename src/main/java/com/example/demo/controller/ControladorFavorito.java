package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entities.Favorite;
import com.example.demo.model.entities.Product;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.service.FavoritesService;

@RestController
public class ControladorFavorito {

	@Autowired
	private FavoritesService gf;

	@PostMapping(path = "Favorito", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Favorite> altaFavorito(@RequestBody Favorite f) {
		try {
			f = gf.saveFav(f);
			if (f != null)
				return new ResponseEntity<Favorite>(f, HttpStatus.CREATED);
			else
				return new ResponseEntity<Favorite>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Favorite>(f, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(path = "Favorito/{usuario}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> buscarProducto(@PathVariable("usuario") UserEntity usuario) {
		try {
			List<Product> paux = null;
			if (usuario != null) {
				paux = gf.listFav(usuario);

			} else {
				paux = null;

			}
			if (paux == null) {
				return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<List<Product>>(paux, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(path = "Favorito/{id_usuario}/{id_producto}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Favorite> cambiarFav(@PathVariable("id_usuario") long id_usuario,
			@PathVariable("id_producto") long id_producto, @RequestBody Favorite f) {
		try {
			f.setFavorito(!f.isFavorito());
			f = gf.saveFav(f);
			if (f != null)
				return new ResponseEntity<Favorite>(f, HttpStatus.OK);
			else
				return new ResponseEntity<Favorite>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Favorite>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
