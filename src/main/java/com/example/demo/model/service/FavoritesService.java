package com.example.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Favorito;
import com.example.demo.model.entities.Producto;
import com.example.demo.model.entities.Usuario;
import com.example.demo.model.persist.FavouriteRepository;

@Service
public class FavoritesService {
	@Autowired
	private FavouriteRepository favoritoDAO;

	public Favorito saveFav(Favorito f) {
		if (favoritoDAO.findFavById(f.getIdFavorito().getId_usuario().getId_usuario(),f.getIdFavorito().getId_producto().getId_producto()) != null) {
			f.setFavorito(!f.isFavorito());
			return favoritoDAO.save(f); 
		}
		else if (f.getIdFavorito().getId_usuario()!=null && f.getIdFavorito().getId_producto() != null) {
			return favoritoDAO.save(f);
		}return null;
	}

	public List<Producto> listFav(Usuario usuario) {
		return favoritoDAO.findFavProductByUser(usuario.getId_usuario());
	}
}
