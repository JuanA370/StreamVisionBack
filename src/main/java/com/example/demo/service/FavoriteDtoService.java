package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.dto.FavoriteResponseDto;
import com.example.demo.model.entities.Favorite;

@Service
public class FavoriteDtoService {
	
	public FavoriteResponseDto createFavoriteResponseDto(Favorite favorite) {
		
		FavoriteResponseDto favoriteResponseDto = FavoriteResponseDto.builder()
				.username(favorite.getUser().getUsername())
				.title(favorite.getProduct().getTitle())
				.saved(favorite.isFavorite())
				.build();
		return favoriteResponseDto;
	}
	
}