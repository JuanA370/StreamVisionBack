package com.example.demo.model.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.entity.Favorito;
import com.example.demo.model.entity.Producto;
import com.example.demo.model.entity.Usuario;
import com.example.demo.model.persist.FavoritoDAO;

public class GestorFavorito {
	@Autowired
	private FavoritoDAO favoritoDAO;

	public Favorito actualizarFavorito(Favorito f) {
		if (favoritoDAO.findFavById(f.getId_usuario(), f.getId_producto())!=null) {
			return favoritoDAO.findFavById(f.getId_usuario(), f.getId_producto());
		}return null;
	}

	public List<Producto> listarFavoritos(Usuario usuario) {
		favoritoDAO.findFavByUser(usuario.getId_usuario());
		return null;
	}

	public Favorito anadirFavorito(Favorito f) {
		if (f.getId_usuario() == null || f.getId_producto() == null) {
			return null;
		}
		return favoritoDAO.save(f);
	}

}
