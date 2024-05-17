package com.example.demo.model.persist.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.Reply;
import com.example.demo.model.entities.ReplyPk;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, ReplyPk> {

	@Query(value = "SELECT r from Respuesta r where r.id_usuario = ?1")
	public List<Reply> findAnsByUserId(Long id_usuario);

	@Query(value = "SELECT r FROM Respuesta r WHERE r.id_usuario = ?1 AND r.id_respuesta.id_hilo = ?2 AND r.id_respuesta.id_producto = ?3")
	public List<Reply> findAns(Long id_usuario, Long id_hilo, Long id_producto);
}
