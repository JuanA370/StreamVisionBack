package com.example.demo.model.persist.dao;

import java.util.List;

import com.example.demo.model.entities.Favorite;
import com.example.demo.model.entities.Product;

public interface FavoriteDao {
	
	public Favorite createFavorite(Product product, Long logeduSerId);
	
	public List<Product> readFavoriteProductsByUserId(Long logeduSerId);
	
	//fav unfav para saber si se guarda
	public Favorite updateFavorite(Product product, Long logedUserId, String action);

}