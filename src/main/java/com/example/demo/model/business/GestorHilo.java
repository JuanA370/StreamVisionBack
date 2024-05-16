package com.example.demo.model.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Hilo;
import com.example.demo.model.persist.HiloDAO;

@Service
public class GestorHilo {

	@Autowired
	private HiloDAO hiloDAO;

	public Hilo crearActualizarHilo(Hilo h) {
		if (h.getTitulo() == null || h.getTitulo().isEmpty()) {
			return null;
		}
		return hiloDAO.save(h);
	}
	
	public void eliminarHilo (Long id_producto,Long id_hilo) {
		hiloDAO.delete(hiloDAO.findHiloById(id_producto, id_hilo));
	}

	public Hilo buscarHilo(Long id_producto, Long id_hilo) {
		return hiloDAO.findHiloById(id_producto, id_hilo);
	}
}
