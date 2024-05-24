package com.example.demo.model.persist.dao;

import java.util.List;

import com.example.demo.model.dto.InteractDto;
import com.example.demo.model.entities.Product;
import com.example.demo.model.entities.Purchase;

public interface PurchaseDao {

	public Purchase createPurchase(InteractDto interactDto, String token);
	
	public List<Product> readPurchasesByUserId(String token);
	
}
