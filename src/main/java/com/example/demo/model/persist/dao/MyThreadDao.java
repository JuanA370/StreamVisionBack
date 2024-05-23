package com.example.demo.model.persist.dao;

import java.util.List;

import com.example.demo.model.dto.ThreadDto;
import com.example.demo.model.entities.MyThread;

public interface MyThreadDao {

	public MyThread createThread (ThreadDto threadDto, Long logedUserId);
	
	public MyThread updateThread (ThreadDto threadDto);
	
	public void deleteThreadById(Long threadId);
	
	public List<MyThread> readThreadsByUserId(Long userId);
	
	public List<MyThread> readThreadsByProductId(Long productId);
	
	public MyThread readThreadById(Long threadId);
	
}