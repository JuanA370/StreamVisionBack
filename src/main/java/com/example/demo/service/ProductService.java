package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.example.demo.exceptions.AppException;
import com.example.demo.model.dto.InteractDto;
import com.example.demo.model.entities.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductService {
	
	@Autowired
	private TmdbService tmdbService;

	public Product extractProductFromTmdbJsonApi(InteractDto interactDto) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		Product extractedProduct = null;

		String json = null;
		if (interactDto.isFilm())
			json = tmdbService.getMovieById(interactDto.tmdbId());
		else
			json = tmdbService.getSeriesById(interactDto.tmdbId());
		
		if (json == null)
			throw new AppException("Error loading external api information", HttpStatus.INTERNAL_SERVER_ERROR);
		
        try {
			extractedProduct = objectMapper.readValue(json, Product.class);
			extractedProduct.setFilm(interactDto.isFilm());
			extractedProduct.setTmdbId(interactDto.tmdbId());
		} catch (Exception e) {
			throw new AppException("Error extacting information from json", HttpStatus.INTERNAL_SERVER_ERROR);
		}
        
		return extractedProduct;
	}
	
}