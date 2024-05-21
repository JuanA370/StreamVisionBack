package com.example.demo.model.persist.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.entities.Product;
import com.example.demo.model.persist.dao.ProductDao;
import com.example.demo.model.persist.repository.ProductRepository;

public class ProductDaoImpl implements ProductDao {

	@Autowired
	private ProductRepository productDao;
	@Override
	public Product saveProduct(Product product) {
		Product returnVar;
		if (product.getTitle() == null || product.getTitle().isEmpty())
			returnVar = null;
		else
		 returnVar = productDao.save(product);
		return returnVar;
	}

	@Override
	public void deleteProduct(Product product) {
		productDao.delete(product);
	}

	@Override
	public List<Product> listProducts() {
		List<Product> products = productDao.findAll();
		return products;
	}

	@Override
	public Product searchProduct(Long productId) {
		Optional<Product> optProduct;
		Product returnVar;
		optProduct = productDao.findById(productId);
		if (optProduct.isPresent())
			returnVar = optProduct.get();
		else
			returnVar = null;
		return returnVar;
	}


	
	
}
