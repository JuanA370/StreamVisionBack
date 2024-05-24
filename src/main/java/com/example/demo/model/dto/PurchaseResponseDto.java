package com.example.demo.model.dto;

import java.sql.Date;

import com.example.demo.model.entities.PurchasePk;

import lombok.Builder;

@Builder
public class PurchaseResponseDto {

	private PurchasePk purchasePk;
	private Date purchaseDate;
	private String title;
	private String imageUrl;
	
}