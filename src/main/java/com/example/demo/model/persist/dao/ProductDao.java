package com.example.demo.model.persist.dao;

import java.util.List;

import com.example.demo.model.entities.Product;

public interface ProductDao {

	public Product saveProduct(Product product);
	
	public void deleteProduct(Product product);
	
	public List<Product> readProducts();
	
	public Product readProductById(Long productId);
	
}