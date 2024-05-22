package com.example.demo.model.persist.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.MyThreadPk;
import com.example.demo.model.entities.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

	@Query(value = "SELECT r from Reply r where r.user.id = ?1")
	public List<Reply> findRepliesByUserId(Long userId);

	//@Query(value = "SELECT r FROM Respuesta r WHERE r.id_usuario = ?1 AND r.id_respuesta.id_hilo = ?2 AND r.id_respuesta.id_producto = ?3")
	//public List<Reply> findReply(Long userId, Long threadId, Long productId);
	
	@Query(value = "SELECT r from Reply r WHERE r.thread.threadPk = ?1")
	public List<Reply> findRepliesByThreadPk(MyThreadPk threadPk);

}
