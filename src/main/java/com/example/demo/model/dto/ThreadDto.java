package com.example.demo.model.dto;

import com.example.demo.model.entities.Product;

import lombok.Builder;

@Builder
public record ThreadDto (
		
		Long id,
		Product product,
		String author,
		String title,
		String content
		
) { }