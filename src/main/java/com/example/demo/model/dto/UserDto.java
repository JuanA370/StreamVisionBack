package com.example.demo.model.dto;


import lombok.Builder;


@Builder
public record UserDto (
	Long id,
	String username,
	String password,
	String email,
	int coins,
	boolean active
) {}
