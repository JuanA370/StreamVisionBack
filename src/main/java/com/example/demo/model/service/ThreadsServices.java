package com.example.demo.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Thread;
import com.example.demo.model.persist.repository.ThreadRepository;

@Service
public class ThreadsServices {

	@Autowired
	private ThreadRepository hiloDAO;

	public Thread saveThread(Thread h) {
		if (h.getTitulo() == null || h.getTitulo().isEmpty()) {
			return null;
		}
		return hiloDAO.save(h);
	}

	public void deleteThread(Long id_producto, Long id_hilo) {
		hiloDAO.delete(hiloDAO.findThreadById(id_producto, id_hilo));
	}

	public Thread searchThread(Long id_producto, Long id_hilo) {
		Optional<Thread> opH;
		opH = Optional.ofNullable(hiloDAO.findThreadById(id_producto, id_hilo));
		if (opH.isPresent()) {
			return opH.get();
		}
		return null;
	}
}
