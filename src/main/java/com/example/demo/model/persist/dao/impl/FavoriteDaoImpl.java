package com.example.demo.model.persist.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.AppException;
import com.example.demo.model.entities.Favorite;
import com.example.demo.model.entities.Product;
import com.example.demo.model.persist.dao.FavoriteDao;
import com.example.demo.model.persist.repository.FavoriteRepository;
import com.example.demo.model.persist.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class FavoriteDaoImpl implements FavoriteDao{
	
	@Autowired
	private FavoriteRepository favoriteRep;
	
	@Autowired
	private ProductRepository productRep;
	
	//NO TIENE SENTIDO
	@Transactional
	@Override
	public Favorite createFavorite(Product product, Long logedUserId) {
		Product savedProduct = productRep.findById(logedUserId).orElse(null);
		if (savedProduct == null) {
			try {
				
			} catch (Exception e) {
				throw new AppException("Relation already exist", HttpStatus.BAD_REQUEST);
			}
		}
			
		
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
