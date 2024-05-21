package com.example.demo.model.persist.dao;

import com.example.demo.model.entities.MyThread;
import com.example.demo.model.entities.MyThreadPk;

public interface MyThreadDao {

	public MyThread createThread (MyThread thread);
	
	//public MyThread updateThread (MyThread thread);
	
	public void deleteThreadByThreadPk(MyThreadPk threadPk);
	
	public MyThread readThreadByThreadPk(MyThreadPk threadPk);
}
