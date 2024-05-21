package com.example.demo.model.persist.dao;

import com.example.demo.model.entities.MyThread;

public interface MyThreadDao {

	public MyThread createThread (MyThread thread);
	
	public MyThread updateThread (MyThread thread);
	
	public void deleteThread(Long productId, Long idThread);
	
	public MyThread searchThread(Long idProduct, Long idThread);
}
