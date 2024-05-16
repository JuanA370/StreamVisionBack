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

	public Favorito actualizarCrearFavorito(Favorito f) {
		if (favoritoDAO.findFavById(f.getIdFavorito().getIdUsuario(),f.getIdFavorito().getIdProducto())!=null) {
			f.setFavorito(!f.isFavorito());
			return favoritoDAO.save(f); 
		}
		else if (f.getIdFavorito().getIdUsuario()!=null&&f.getIdFavorito().getIdProducto()!=null) {
			return favoritoDAO.save(f);
		}return null;
	}

	public List<Producto> listarFavoritos(Usuario usuario) {
		return favoritoDAO.findFavByUser(usuario.getId_usuario());
	}
}
