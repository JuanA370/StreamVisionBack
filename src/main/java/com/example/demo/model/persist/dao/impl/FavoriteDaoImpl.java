package com.example.demo.model.persist.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Favorite;
import com.example.demo.model.entities.Product;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.persist.dao.FavoriteDao;
import com.example.demo.model.persist.repository.FavoriteRepository;

@Service
public class FavoriteDaoImpl implements FavoriteDao{
	
	private FavoriteRepository favoriteRep;
	
	@Override
	public Favorite createFavorite(Favorite favorite) {
		Favorite createdFavorite = favoriteRep.save(favorite);
		return createdFavorite;
	}

	@Override
	public Favorite updateFavorite(Favorite favorite) {
		Favorite createdFavorite = favoriteRep.save(favorite);
		return createdFavorite;
	}
	
	@Override
	public List<Product> readFavoriteProductsByUserId(Long userId) {
		List<Product> products = favoriteRep.findFavoriteProductByUserId(userId);
		return products;
	}
	
}
