package com.example.demo.model.persist.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.entities.MyThread;
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
	public void deleteThread(Long idProduct, Long idThread) {
		threadDao.delete(threadDao.findThreadById(idProduct, idThread));
	}

	@Override
	public MyThread searchThread(Long idProduct, Long idThread) {
		Optional<MyThread> optThread;
		MyThread returnVar;
		optThread = Optional.ofNullable(threadDao.findThreadById(idProduct, idThread));
		if (optThread.isPresent())
			returnVar = optThread.get();
		else
			returnVar = null;
		return returnVar;
	}
	
}
