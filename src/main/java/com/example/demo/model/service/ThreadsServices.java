package com.example.demo.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.MyThread;
import com.example.demo.model.persist.repository.MyThreadRepository;

@Service
public class ThreadsServices {

	@Autowired
	private MyThreadRepository hiloDAO;

	public MyThread saveThread(MyThread h) {
		if (h.getTitulo() == null || h.getTitulo().isEmpty()) {
			return null;
		}
		return hiloDAO.save(h);
	}

	public void deleteThread(Long id_producto, Long id_hilo) {
		hiloDAO.delete(hiloDAO.findThreadById(id_producto, id_hilo));
	}

	public MyThread searchThread(Long id_producto, Long id_hilo) {
		Optional<MyThread> opH;
		opH = Optional.ofNullable(hiloDAO.findThreadById(id_producto, id_hilo));
		if (opH.isPresent()) {
			return opH.get();
		}
		return null;
	}
}
