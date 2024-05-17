package com.example.demo.model.persist.dao;

import com.example.demo.model.entities.MyThread;

public interface MyThreadDao {

	public MyThread saveThread (MyThread thread);
	
	public void deleteThread(Long product_id, Long thread_id);
	
	public MyThread searchThread(Long product_id, Long thread_id);
}
