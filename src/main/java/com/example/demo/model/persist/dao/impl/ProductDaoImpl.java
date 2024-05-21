package com.example.demo.model.persist.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.example.demo.exceptions.AppException;
import com.example.demo.model.entities.Product;
import com.example.demo.model.persist.dao.ProductDao;
import com.example.demo.model.persist.repository.ProductRepository;

public class ProductDaoImpl implements ProductDao {

	@Autowired
	private ProductRepository productDao;
	@Override
	public Product saveProduct(Product product) {
		Product savedProduct;
		if (product.getTitle() == null || product.getTitle().isEmpty())
			savedProduct = null;
		else
			savedProduct = productDao.save(product);
		return savedProduct;
	}

	@Override
	public void deleteProduct(Product product) {
		productDao.delete(product);
	}

	@Override
	public List<Product> readProducts() {
		List<Product> products = productDao.findAll();
		if (products.isEmpty())
			throw new AppException("Found no products", HttpStatus.NOT_FOUND);
		return products;
	}

	@Override
	public Product readProductById(Long productId) {
		Optional<Product> optProduct;
		Product product;
		optProduct = productDao.findById(productId);
		if (optProduct.isPresent())
			product = optProduct.get();
		else
			product = null;
		return product;
	}


	
	
}
