package com.example.demo.model.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.entity.Hilo;
import com.example.demo.model.persist.HiloDAO;

public class GestorHilo {

	@Autowired
	private HiloDAO hiloDAO;
	
	public Hilo crearActualizarHilo(Hilo h) {
		if(h.getTitulo() == null || h.getTitulo().isEmpty()) {
			return null;
		}
		return hiloDAO.save(h);
	}
	
	public void eliminarHilo(Hilo h) {
		hiloDAO.delete(h);
	}
	
	public List<Hilo> listarHilos() {
		return hiloDAO.findAll();
	}
	
	public Hilo buscarHilo(int id) {
		Optional<Hilo> opH;
		opH = hiloDAO.findById(id);
		if (opH.isPresent()) {
			return opH.get();
		} else {
			return null;
		}
	}
}
