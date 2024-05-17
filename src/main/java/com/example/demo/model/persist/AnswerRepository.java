package com.example.demo.model.persist;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.Respuesta;
import com.example.demo.model.entities.RespuestaId;

@Repository
public interface AnswerRepository extends JpaRepository<Respuesta, RespuestaId> {
	
	@Query(value = "SELECT r from Respuesta r where r.id_usuario = ?1")
	public List<Respuesta> findAnsByUserId(Long id_usuario);

	
	@Query(value = "SELECT r FROM Respuesta r WHERE r.id_usuario = ?1 AND r.id_respuesta.id_hilo = ?2 AND r.id_respuesta.id_producto = ?3")
	public List<Respuesta> findByUsuarioAndHiloAndProducto(Long id_usuario,
			Long id_hilo, Long id_producto);
	
}
