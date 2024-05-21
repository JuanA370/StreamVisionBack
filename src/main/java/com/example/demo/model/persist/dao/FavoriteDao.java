package com.example.demo.model.persist.dao;

import java.util.List;

import com.example.demo.model.entities.Favorite;
import com.example.demo.model.entities.Product;
import com.example.demo.model.entities.UserEntity;

public interface FavoriteDao {
	
	public Favorite createFavorite(Favorite favorite);
	
	public List<Product> readFavoriteProductsByUser(UserEntity user);
	
	public Favorite updateFavorite(Favorite favorite);

}
