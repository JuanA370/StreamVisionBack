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
public class FavoriteRestController {

	@Autowired
	private FavoritesService gf;

	@PostMapping(path = "Favorite", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Favorite> addFavorite(@RequestBody Favorite f) {
		ResponseEntity<Favorite> returnVar;
		try {
			f = gf.saveFav(f);
			if (f != null)
				returnVar = new ResponseEntity<Favorite>(f, HttpStatus.CREATED);
			else
				returnVar = new ResponseEntity<Favorite>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			returnVar = new ResponseEntity<Favorite>(f, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return returnVar;
	}

	@GetMapping(path = "Favorite/{user}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> searchProduct(@PathVariable("user") UserEntity usuario) {
		ResponseEntity<List<Product>> returnVar;
		try {
			List<Product> paux = null;
			if (usuario != null) {
				paux = gf.listFav(usuario);

			} else {
				paux = null;

			}
			if (paux == null) {
				returnVar = new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
			} else {
				returnVar = new ResponseEntity<List<Product>>(paux, HttpStatus.OK);
			}
		} catch (Exception e) {
			returnVar = new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return returnVar;
	}

	@PutMapping(path = "Favorite/{userId}/{productId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Favorite> changueisFav(@PathVariable("userId") long id_usuario,
			@PathVariable("productId") long id_producto, @RequestBody Favorite f) {
		ResponseEntity<Favorite> returnVar;
		try {
			f.setFavorite(!f.isFavorite());
			f = gf.saveFav(f);
			if (f != null)
				returnVar = new ResponseEntity<Favorite>(f, HttpStatus.OK);
			else
				returnVar = new ResponseEntity<Favorite>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			returnVar = new ResponseEntity<Favorite>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return returnVar;
	}
}
