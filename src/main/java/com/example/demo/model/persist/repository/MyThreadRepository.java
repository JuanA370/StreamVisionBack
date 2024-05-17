package com.example.demo.model.persist.repository;
	
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.MyThread;
import com.example.demo.model.entities.MyThreadPk;

@Repository
public interface MyThreadRepository extends JpaRepository<MyThread, MyThreadPk>{
	
	@Query(value = "SELECT h FROM Hilo h WHERE h.idHilo.id_producto.id_producto = ?1 AND h.idHilo.id_hilo = ?2")
	public MyThread findThreadById(Long id_producto, Long id_hilo);
}
