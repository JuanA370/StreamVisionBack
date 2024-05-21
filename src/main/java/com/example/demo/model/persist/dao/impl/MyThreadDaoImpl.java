package com.example.demo.model.persist.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.entities.MyThread;
import com.example.demo.model.entities.MyThreadPk;
import com.example.demo.model.persist.dao.MyThreadDao;
import com.example.demo.model.persist.repository.MyThreadRepository;

public class MyThreadDaoImpl implements MyThreadDao {
	
	@Autowired
	private MyThreadRepository threadDao;
	
	@Override
	public MyThread createThread(MyThread thread) {
		MyThread returnVar;
		if(thread.getTitle() == null || thread.getTitle().isEmpty())
			returnVar = null;
		else
			returnVar = threadDao.save(thread);
		return returnVar;
	}

	@Override
	public void deleteThreadByThreadPk(MyThreadPk threadPk) {
		threadDao.delete(threadDao.findThreadByThreadPk(threadPk));
	}

	@Override
	public MyThread readThreadByThreadPk(MyThreadPk threadPk) {
		Optional<MyThread> optThread;
		MyThread thread;
		optThread = Optional.ofNullable(threadDao.findThreadByThreadPk(threadPk));
		if (optThread.isPresent())
			thread = optThread.get();
		else
			thread = null;
		return thread;
	}
	
}
