package com.example.demo.model.persist.dao;

import java.util.List;

import com.example.demo.model.entities.Favorite;
import com.example.demo.model.entities.Product;
import com.example.demo.model.entities.UserEntity;

public interface FavouriteDao {
	
	public Favorite saveFav(Favorite f);
	public List<Product> listFav(UserEntity usuario);
}
