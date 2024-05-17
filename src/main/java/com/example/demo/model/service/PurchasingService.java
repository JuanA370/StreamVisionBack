package com.example.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Purchase;
import com.example.demo.model.entities.Product;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.persist.repository.PurchaseRepository;

@Service
public class PurchasingService {

	@Autowired
	private PurchaseRepository compraDAO;

	public Purchase saveShopping(Purchase c) {
		if (compraDAO.findShoppingByUserANDProduct(c.getIdCompra().getId_usuario().getId_usuario(),
				c.getIdCompra().getId_producto().getId_producto()) == null
				&& (c.getIdCompra().getId_usuario() == null && c.getIdCompra().getId_producto() == null))
			return compraDAO.save(c);
		return null;
	}

	public List<Product> listShopping(UserEntity usuario) {
		return compraDAO.findShoppedProductsByUser(usuario.getId_usuario());
	}
}