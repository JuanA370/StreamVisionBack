package com.example.demo.model.persist.repository;
	
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.Thread;
import com.example.demo.model.entities.ThreadPk;

@Repository
public interface ThreadRepository extends JpaRepository<Thread, ThreadPk>{
	
	@Query(value = "SELECT h FROM Hilo h WHERE h.idHilo.id_producto.id_producto = ?1 AND h.idHilo.id_hilo = ?2")
	public Thread findThreadById(Long id_producto, Long id_hilo);
}
