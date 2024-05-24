package com.example.demo.model.persist.dao;

import java.util.List;

import com.example.demo.model.dto.InteractDto;
import com.example.demo.model.entities.Favorite;
import com.example.demo.model.entities.Product;

public interface FavoriteDao {
	
	public Favorite createFavorite(InteractDto interactDto, Long logedUserId);
	
	public List<Product> readFavoriteProductsByUserId(String token);
	
	//fav unfav para saber si se guarda
	public Favorite updateFavorite(InteractDto interactDto, String toke, String action);

}