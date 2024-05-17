package com.example.demo.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Compra;
import com.example.demo.model.entities.Producto;
import com.example.demo.model.entities.Usuario;
import com.example.demo.model.persist.ShoppingRepository;

@Service
public class PurchasingService {

	@Autowired
	private ShoppingRepository compraDAO;

	public Compra saveShopping(Compra c) {
		if (compraDAO.findCompraPorUsuarioYProducto(c.getIdCompra().getId_usuario().getId_usuario(),
				c.getIdCompra().getId_producto().getId_producto()) == null
				&& (c.getIdCompra().getId_usuario() == null && c.getIdCompra().getId_producto() == null))
			return compraDAO.save(c);
		return null;
	}

	public List<Producto> listShopping(Usuario usuario) {
		return compraDAO.findProductosCompradosPorUsuario(usuario.getId_usuario());
	}
}