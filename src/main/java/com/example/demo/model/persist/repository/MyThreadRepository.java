package com.example.demo.model.persist.repository;
	
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.MyThread;

@Repository
public interface MyThreadRepository extends JpaRepository<MyThread, Long>{

	@Query("SELECT t FROM Thread t WHERE Thread.user.id =?1")
	public List<MyThread> findThreadsByUserId(Long userId);
	
	@Query("SELECT t FROM Thread t WHERE Thread.product.id =?1")
	public List<MyThread> findThreadsByProductId(Long productId);
	
}