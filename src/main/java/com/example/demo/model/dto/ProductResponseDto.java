package com.example.demo.model.dto;

import lombok.Builder;

@Builder
public class ProductResponseDto {
	
	private String product;
	private boolean isSaved;
	private boolean isPurchased;
}
