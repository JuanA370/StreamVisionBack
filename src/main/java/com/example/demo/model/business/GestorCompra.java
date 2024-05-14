package com.example.demo.model.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.entity.Compra;
import com.example.demo.model.entity.Producto;
import com.example.demo.model.entity.Usuario;
import com.example.demo.model.persist.CompraDAO;

public class GestorCompra {

	@Autowired
	private CompraDAO compraDAO;
	
	public Compra anadirCompra(Compra c) {
		if(c.getId_producto() == null || c.getId_usuario() == null)
			return null;
		return compraDAO.save(c);
	}
	
	public List<Producto> listarCompras(Usuario usuario) {
		return compraDAO.findCompraByUser(usuario.getId_usuario());
	}
	
	public Producto buscarCompra(Compra c) {
		Optional<Producto> opP;
		opP = compraDAO.findProductoComprado(c.getId_usuario(), c.getId_producto());
		if (opP.isPresent()) {
			return opP.get();
		} else {
			return null;
		}
	}
}
