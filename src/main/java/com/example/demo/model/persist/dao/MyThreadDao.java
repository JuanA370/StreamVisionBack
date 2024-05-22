package com.example.demo.model.persist.dao;

import com.example.demo.model.entities.MyThread;

public interface MyThreadDao {

	public MyThread createThread (MyThread thread);
	
	//public MyThread updateThread (MyThread thread);
	
	public void deleteThreadById(Long threadId);
	
	public MyThread readThreadById(Long threadId);
	
}
