package com.example.demo.model.persist;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Respuesta;

@Repository
public interface RespuestaDAO extends JpaRepository<Respuesta, Long> {
	
    List<Respuesta> findByUsuarioId(long id_usuario);
	
//select id_respuesta from Respuesta where id_usuario =:id_usuario and id_hilo=:id_hilo and id_producto=:id_producto
	@Query("SELECT r FROM Respuesta r WHERE r.id_usuario = :id_usuario AND r.id_hilo = :id_hilo AND r.id_producto = :id_producto")
		List<Respuesta> findByUsuarioAndHiloAndProducto(
		        @Param("id_usuario") long id_usuario,
		        @Param("id_hilo") long id_hilo,
		        @Param("id_producto") long id_producto
		);

//	    @Modifying
//	    @Query("DELETE FROM Respuesta r WHERE r.id_respuesta = :id_respuesta AND r.id_usuario = :id_usuario AND r.id_hilo = :id_hilo AND r.id_producto = :id_producto")
//	    void deleteByCriteria(long id_respuesta, long id_usuario, long id_hilo, long id_producto);

}
