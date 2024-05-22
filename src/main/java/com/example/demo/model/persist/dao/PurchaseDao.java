package com.example.demo.model.persist.dao;

import java.util.List;

import com.example.demo.model.entities.Product;
import com.example.demo.model.entities.Purchase;

public interface PurchaseDao {

	public Purchase createPurchase(Product product, Long logedUserId);
	
	public List<Product> readPurchasesByUserId(Long userId);
	
}
