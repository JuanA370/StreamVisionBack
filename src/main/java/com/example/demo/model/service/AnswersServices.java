package com.example.demo.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Respuesta;
import com.example.demo.model.persist.AnswerRepository;

@Service
public class AnswersServices {

	@Autowired
	private AnswerRepository respuestaDAO;

	public Respuesta saveAns(Respuesta r) {
		return respuestaDAO.save(r);
	}

	public void deleteAns(Respuesta r) {
		respuestaDAO.delete(r);
	}

	public List<Respuesta> listAns(Long id_usuario) {
		return respuestaDAO.findAnsByUserId(id_usuario);
	}

	public List<Respuesta> searchAns(Long id_usuario, Long id_hilo, Long id_producto) {
		List<Respuesta> respuestas = respuestaDAO.findAns(id_usuario, id_hilo, id_producto);
		return respuestas;
	}
}