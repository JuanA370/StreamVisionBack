package com.example.demo.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Reply;
import com.example.demo.model.persist.repository.ReplyRepository;

@Service
public class AnswersServices {

	@Autowired
	private ReplyRepository respuestaDAO;

	public Reply saveAns(Reply r) {
		return respuestaDAO.save(r);
	}

	public void deleteAns(Reply r) {
		respuestaDAO.delete(r);
	}

	public List<Reply> listAns(Long id_usuario) {
		return respuestaDAO.findAnsByUserId(id_usuario);
	}

	public List<Reply> searchAns(Long id_usuario, Long id_hilo, Long id_producto) {
		List<Reply> respuestas = respuestaDAO.findAns(id_usuario, id_hilo, id_producto);
		return respuestas;
	}
}