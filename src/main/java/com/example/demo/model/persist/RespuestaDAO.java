package com.example.demo.model.persist;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Respuesta;

@Repository
public interface RespuestaDAO extends JpaRepository<Respuesta, Long> {

	List<Respuesta> findByUsuarioId(Long id_usuario);

	@Query("SELECT r FROM Respuesta r WHERE r.id_usuario = :id_usuario AND r.id_hilo = :id_hilo AND r.id_producto = :id_producto")
	List<Respuesta> findByUsuarioAndHiloAndProducto(@Param("id_usuario") Long id_usuario,
			@Param("id_hilo") Long id_hilo, @Param("id_producto") Long id_producto);
}
