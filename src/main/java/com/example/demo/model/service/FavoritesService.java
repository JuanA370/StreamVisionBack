package com.example.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Favorite;
import com.example.demo.model.entities.Product;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.persist.repository.FavoriteRepository;

@Service
public class FavoritesService {
	@Autowired
	private FavoriteRepository favoritoDAO;

	public Favorite saveFav(Favorite f) {
		if (favoritoDAO.findFavById(f.getIdFavorito().getId_usuario().getId_usuario(),f.getIdFavorito().getId_producto().getId_producto()) != null) {
			f.setFavorito(!f.isFavorito());
			return favoritoDAO.save(f); 
		}
		else if (f.getIdFavorito().getId_usuario()!=null && f.getIdFavorito().getId_producto() != null) {
			return favoritoDAO.save(f);
		}return null;
	}

	public List<Product> listFav(UserEntity usuario) {
		return favoritoDAO.findFavProductByUser(usuario.getId_usuario());
	}
}
