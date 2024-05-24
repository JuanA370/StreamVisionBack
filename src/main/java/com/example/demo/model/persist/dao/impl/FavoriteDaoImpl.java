package com.example.demo.model.persist.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.AppException;
import com.example.demo.model.dto.InteractDto;
import com.example.demo.model.entities.Favorite;
import com.example.demo.model.entities.FavoritePk;
import com.example.demo.model.entities.Product;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.persist.dao.FavoriteDao;
import com.example.demo.model.persist.repository.FavoriteRepository;
import com.example.demo.model.persist.repository.ProductRepository;
import com.example.demo.model.persist.repository.UserRepository;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.service.ProductService;

@Service
public class FavoriteDaoImpl implements FavoriteDao {

	@Autowired
	private FavoriteRepository favoriteRep;

	@Autowired
	private ProductRepository productRep;

	@Autowired
	private UserRepository userRep;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Override
	public Favorite createFavorite(InteractDto interactDto, Long logedUserId) {
		
		Product savedProduct = productRep.findProductByIsFilmAndTmdbId(interactDto.isFilm(), interactDto.tmdbId());
		if (savedProduct == null) {
			Product externalProduct = productService.extractProductFromTmdbJsonApi(interactDto);
			savedProduct = productRep.save(externalProduct);
		}
			
		UserEntity user = userRep.findById(logedUserId)
				.orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
		
		Favorite favorite = Favorite.builder()
				.favoritePk(new FavoritePk(logedUserId, savedProduct.getProductId()))
				.product(savedProduct)
				.user(user)
				.isFavorite(false)
				.build();
		
		Favorite createdFavorite = favoriteRep.save(favorite);
		return createdFavorite;
	}

	@Override
	public Favorite updateFavorite(InteractDto interactDto, String token, String action) {
		
		Long logedUserId = jwtUtils.getUserIdFromToken(token);
		Product extractedProduct = productService.extractProductFromTmdbJsonApi(interactDto);
		FavoritePk favoritePk = new FavoritePk(extractedProduct.getProductId(), logedUserId);
		
		if (!action.equals("SAVE") && !action.equals("UNSAVE"))
				throw new AppException("Unknown action", HttpStatus.BAD_REQUEST);
		
		Favorite favorite = favoriteRep.findFavoriteByFavoritePk(favoritePk);
		if (favorite == null)
			createFavorite(interactDto, logedUserId);
		
		if (action == "SAVE" && favorite.isFavorite())
			throw new AppException("Product already saved", HttpStatus.FORBIDDEN);
		else if (action == "SAVE" && !favorite.isFavorite())
			favorite.setFavorite(true);
		else if (action == "UNSAVE" && !favorite.isFavorite())
			throw new AppException("Product already unsaved", HttpStatus.FORBIDDEN);
		else if (action == "UNSAVE" && favorite.isFavorite())
			favorite.setFavorite(false);
			
		Favorite updatedFavorite = favoriteRep.save(favorite);
		return updatedFavorite;
	}

	@Override
	public List<Product> readFavoriteProductsByUserId(String token) {
		
		Long logedUserId = jwtUtils.getUserIdFromToken(token);
		
		List<Product> products = favoriteRep.findFavoriteProductByUserId(logedUserId);
		
		if (products == null || products.isEmpty())
			throw new AppException("No saved products found for this user", HttpStatus.NO_CONTENT);
		return products;
	}

}
