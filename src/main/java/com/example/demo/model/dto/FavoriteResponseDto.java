package com.example.demo.model.dto;

import lombok.Builder;

@Builder
public class FavoriteResponseDto {

	private String username;
	private String title;
	private boolean saved;
	
}
