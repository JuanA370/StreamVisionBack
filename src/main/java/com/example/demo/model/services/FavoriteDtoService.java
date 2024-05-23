package com.example.demo.model.services;

import com.example.demo.model.dto.FavoriteResponseDto;
import com.example.demo.model.entities.Favorite;

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