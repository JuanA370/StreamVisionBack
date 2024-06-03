package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.dto.FavoriteResponseDto;
import com.example.demo.model.dto.PostResponseDto;
import com.example.demo.model.dto.PurchaseResponseDto;
import com.example.demo.model.entities.Favorite;
import com.example.demo.model.entities.Post;
import com.example.demo.model.entities.Purchase;

@Service
public class InteractionDtoService {
	
	public FavoriteResponseDto createFavoriteResponseDto(Favorite favorite) {
		FavoriteResponseDto favoriteResponseDto = FavoriteResponseDto.builder()
				.username(favorite.getUser().getUsername())
				.title(favorite.getProduct().getOfficialName())
				.saved(favorite.isFavorite())
				.build();
		return favoriteResponseDto;
	}
	
	public PurchaseResponseDto createPurchaseResponseDto(Purchase purchase) {
		PurchaseResponseDto purchaseResponseDto = PurchaseResponseDto.builder()
				.username(purchase.getUser().getUsername())
				.title(purchase.getProduct().getOfficialName())
				.purchased(true)
				.build();
		return purchaseResponseDto;
	}
	
	public PostResponseDto createPostResponseDto(Post post) {
		PostResponseDto postResponseDto = PostResponseDto.builder()
				.localRating(post.getLocalRating())
				.content(post.getContent())
				.author(post.getUser().getUsername())
				.postDate(post.getPostDate())
				.build();
		return postResponseDto;
	}
}