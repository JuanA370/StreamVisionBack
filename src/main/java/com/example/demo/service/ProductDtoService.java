package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ProductResponseDto;
import com.example.demo.model.entities.Favorite;
import com.example.demo.model.entities.Purchase;
import com.example.demo.model.persist.repository.FavoriteRepository;
import com.example.demo.model.persist.repository.ProductRepository;
import com.example.demo.model.persist.repository.PurchaseRepository;
import com.example.demo.security.jwt.JwtUtils;

@Service
public class ProductDtoService {
	
	@Autowired
	private JwtUtils jwtUtils;
	

	public ProductResponseDto createProductResponseDto(String product, String token, Long tmdbId, boolean isFilm) {
		
		token = token.substring(7);
		Long logedUserId = jwtUtils.getUserIdFromToken(token);
	
		return null;
	}
}
