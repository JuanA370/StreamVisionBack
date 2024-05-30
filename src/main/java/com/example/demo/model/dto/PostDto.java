package com.example.demo.model.dto;

import com.example.demo.model.entities.Product;

import lombok.Builder;

@Builder
public record PostDto (
		
		Long id,
		Product product,
		int localRating,
		String content
		
) { }