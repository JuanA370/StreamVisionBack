package com.example.demo.model.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Compra;
import com.example.demo.model.entity.Producto;
import com.example.demo.model.entity.Usuario;
import com.example.demo.model.persist.CompraDAO;

@Service
public class GestorCompra {

	@Autowired
	private CompraDAO compraDAO;

	public Compra anadirCompra(Compra c) {
		if (compraDAO.findCompraPorUsuarioYProducto(c.getIdCompra().getId_usuario().getId_usuario(),
				c.getIdCompra().getId_producto().getId_producto()) == null
				&& (c.getIdCompra().getId_usuario() == null && c.getIdCompra().getId_producto() == null))
			return compraDAO.save(c);

		return null;
	}

	public List<Producto> listarCompras(Usuario usuario) {
		return compraDAO.findProductosCompradosPorUsuario(usuario.getId_usuario());
	}

}
