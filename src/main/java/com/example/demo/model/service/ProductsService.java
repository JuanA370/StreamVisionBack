package com.example.demo.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Producto;
import com.example.demo.model.persist.ProductRepository;

@Service
public class ProductsService {

	@Autowired
	private ProductRepository productoDAO;

	public Producto saveProduct(Producto p) {
		if (p.getTitulo() == null || p.getTitulo().isEmpty()) {
			return null;
		}
		return productoDAO.save(p);
	}

	public void deleteProduct(Producto p) {
		productoDAO.delete(p);
	}

	public List<Producto> listProducts() {
		return productoDAO.findAll();
	}

	public Producto searchProduct(int id) {
		Optional<Producto> opP;
		opP = productoDAO.findById(id);
		if (opP.isPresent()) {
			return opP.get();
		} else {
			return null;
		}
	}
}