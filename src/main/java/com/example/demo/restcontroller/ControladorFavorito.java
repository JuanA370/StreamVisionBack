package com.example.demo.restcontroller;

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

import com.example.demo.model.business.GestorFavorito;
import com.example.demo.model.entity.Favorito;
import com.example.demo.model.entity.Producto;
import com.example.demo.model.entity.Usuario;

@RestController
public class ControladorFavorito {

	@Autowired
	private GestorFavorito gf;

	@PostMapping(path = "Favorito", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Favorito> altaFavorito(@RequestBody Favorito f) {
		try {
			f = gf.anadirFavorito(f);
			if (f != null)
				return new ResponseEntity<Favorito>(f, HttpStatus.CREATED);
			else
				return new ResponseEntity<Favorito>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Favorito>(f, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(path = "Favorito/{usuario}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Producto>> buscarProducto(@PathVariable("usuario") Usuario usuario) {
		try {
			List<Producto> paux = null;
			if (usuario != null) {
				paux = gf.listarFavoritos(usuario);

			} else {
				paux = null;

			}
			if (paux == null) {
				return new ResponseEntity<List<Producto>>(paux, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<Producto>>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<List<Producto>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(path = "Favorito/{id_usuario}/{id_producto}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Favorito> cambiarFav(@PathVariable("id_usuario") long id_usuario,
			@PathVariable("id_producto") long id_producto, @RequestBody Favorito f) {
		try {
			f.setFavorito(!f.isFavorito());
			f = gf.actualizarFavorito(f);
			if (f != null)
				return new ResponseEntity<Favorito>(f, HttpStatus.OK);
			else
				return new ResponseEntity<Favorito>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Favorito>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
