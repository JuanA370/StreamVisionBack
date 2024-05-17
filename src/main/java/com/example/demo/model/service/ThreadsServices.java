package com.example.demo.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Hilo;
import com.example.demo.model.persist.ThreadRepository;

@Service
public class ThreadsServices {

	@Autowired
	private ThreadRepository hiloDAO;

	public Hilo saveThread(Hilo h) {
		if (h.getTitulo() == null || h.getTitulo().isEmpty()) {
			return null;
		}
		return hiloDAO.save(h);
	}

	public void deleteThread(Long id_producto, Long id_hilo) {
		hiloDAO.delete(hiloDAO.findHiloById(id_producto, id_hilo));
	}

	public Hilo searchThread(Long id_producto, Long id_hilo) {
		Optional<Hilo> opH;
		opH = Optional.ofNullable(hiloDAO.findHiloById(id_producto, id_hilo));
		if (opH.isPresent()) {
			return opH.get();
		}
		return null;
	}
}
