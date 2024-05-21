package com.example.demo.model.persist.repository;
	
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.MyThread;
import com.example.demo.model.entities.MyThreadPk;

@Repository
public interface MyThreadRepository extends JpaRepository<MyThread, MyThreadPk>{
	
	public MyThread findThreadByThreadPk(MyThreadPk threadPk);
}
