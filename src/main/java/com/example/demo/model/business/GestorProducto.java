package com.example.demo.model.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Producto;
import com.example.demo.model.persist.ProductoDAO;

@Service
public class GestorProducto {

	@Autowired
	private ProductoDAO productoDAO;

	public Producto crearActualizarProducto(Producto p) {
		if (p.getTitulo() == null || p.getTitulo().isEmpty()) {
			return null;
		}
		return productoDAO.save(p);
	}

	public void eliminarProducto(Producto p) {
		productoDAO.delete(p);
	}

	public List<Producto> listarProductos() {
		return productoDAO.findAll();
	}

	public Producto buscarProducto(int id) {
		Optional<Producto> opP;
		opP = productoDAO.findById(id);
		if (opP.isPresent()) {
			return opP.get();
		} else {
			return null;
		}
	}

}
