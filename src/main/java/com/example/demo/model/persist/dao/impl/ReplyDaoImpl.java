package com.example.demo.model.persist.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Reply;
import com.example.demo.model.persist.dao.ReplyDao;
import com.example.demo.model.persist.repository.ReplyRepository;

@Service
public class ReplyDaoImpl implements ReplyDao{

	@Autowired
	private ReplyRepository replyRep;
	
	@Override
	public Reply saveReply(Reply reply) {
		return replyRep.save(reply);
	}
	
	public void deleteReply(Reply reply) {
		replyRep.delete(reply);
	}

	public List<Reply> listReply(long id_usuario) {
		return replyRep.findAnsByUserId(id_usuario);
	}

	public List<Reply> searchReply(Long id_usuario, Long id_hilo, Long id_producto) {
		List<Reply> respuestas = replyRep.findAns(id_usuario, id_hilo, id_producto);
		return respuestas;
	}

}
