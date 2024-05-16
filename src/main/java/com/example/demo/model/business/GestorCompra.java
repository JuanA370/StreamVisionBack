package com.example.demo.model.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.entity.Compra;
import com.example.demo.model.entity.Producto;
import com.example.demo.model.entity.Usuario;
import com.example.demo.model.persist.CompraDAO;

public class GestorCompra {

	@Autowired
	private CompraDAO compraDAO;

	public Compra anadirCompra(Compra c) {
		if (compraDAO.findCompraPorUsuarioYProducto(c.getIdCompra().getIdUsuario(),
				c.getIdCompra().getIdProducto()) == null
				&& (c.getIdCompra().getIdUsuario() == null && c.getIdCompra().getIdProducto() == null))
			return compraDAO.save(c);

		return null;
	}

	public List<Producto> listarCompras(Usuario usuario) {
		return compraDAO.findProductosCompradosPorUsuario(usuario.getId_usuario());
	}

}
