package com.example.demo.model.dto;


import lombok.Builder;

@Builder
public record PostDto (
		
		Long id,
		int localRating,
		String content
		
) { }