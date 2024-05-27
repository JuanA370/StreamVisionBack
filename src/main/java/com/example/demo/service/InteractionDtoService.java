package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.dto.FavoriteResponseDto;
import com.example.demo.model.dto.PurchaseResponseDto;
import com.example.demo.model.entities.Favorite;
import com.example.demo.model.entities.Purchase;

@Service
public class InteractionDtoService {
	
	public FavoriteResponseDto createFavoriteResponseDto(Favorite favorite) {
		FavoriteResponseDto favoriteResponseDto = FavoriteResponseDto.builder()
				.username(favorite.getUser().getUsername())
				.title(favorite.getProduct().getOriginal_title())
				.saved(favorite.isFavorite())
				.build();
		return favoriteResponseDto;
	}
	
	public PurchaseResponseDto createPurchaseResponseDto(Purchase purchase) {
		PurchaseResponseDto purchaseResponseDto = PurchaseResponseDto.builder()
				.username(purchase.getUser().getUsername())
				.title(purchase.getProduct().getOriginal_title())
				.purchased(true)
				.build();
		return purchaseResponseDto;
	}
	
}