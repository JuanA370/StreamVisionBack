package com.example.demo.model.persist;
	
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Hilo;

@Repository
public interface HiloDAO extends JpaRepository<Hilo, Integer>{
	
	@Query(value = "SELECT * FROM Hilo h WHERE h.id_producto = ?1 AND id_hilo = ?2")
	public Hilo findHiloById(Long id_producto, Long id_hilo);
}
