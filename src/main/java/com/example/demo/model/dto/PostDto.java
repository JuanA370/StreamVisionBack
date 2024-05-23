package com.example.demo.model.dto;

import com.example.demo.model.entities.Product;

import lombok.Builder;

@Builder
public record PostDto (
		
		Long id,
		Long repliedPostId,
		Product product,
		String title,
		String content
		
) { }