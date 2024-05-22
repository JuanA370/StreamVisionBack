package com.example.demo.model.persist.repository;
	
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.MyThread;

@Repository
public interface MyThreadRepository extends JpaRepository<MyThread, Long>{

}
