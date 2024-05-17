package com.example.demo.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Product;
import com.example.demo.model.persist.repository.ProductRepository;

@Service
public class ProductsService {

	@Autowired
	private ProductRepository productoDAO;

	public Product saveProduct(Product p) {
		if (p.getTitulo() == null || p.getTitulo().isEmpty()) {
			return null;
		}
		return productoDAO.save(p);
	}

	public void deleteProduct(Product p) {
		productoDAO.delete(p);
	}

	public List<Product> listProducts() {
		return productoDAO.findAll();
	}

	public Product searchProduct(Long id) {
		Optional<Product> opP;
		opP = productoDAO.findById(id);
		if (opP.isPresent()) {
			return opP.get();
		} else {
			return null;
		}
	}
}