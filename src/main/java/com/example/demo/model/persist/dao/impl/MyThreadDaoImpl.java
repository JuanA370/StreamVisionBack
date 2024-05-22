package com.example.demo.model.persist.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.example.demo.exceptions.AppException;
import com.example.demo.model.dto.ThreadDto;
import com.example.demo.model.entities.MyThread;
import com.example.demo.model.entities.Product;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.persist.dao.MyThreadDao;
import com.example.demo.model.persist.repository.MyThreadRepository;
import com.example.demo.model.persist.repository.ProductRepository;
import com.example.demo.model.persist.repository.UserRepository;

public class MyThreadDaoImpl implements MyThreadDao {
	
	@Autowired
	private MyThreadRepository threadRep;
	
	@Autowired
	private ProductRepository productRep;
	
	@Autowired
	private UserRepository userRep;

	@Override
	public ThreadDto createThread(ThreadDto threadDto, Long logedUserId) {
		
		Product savedProduct = productRep.findById(threadDto.threadId()).orElse(null);
		if (savedProduct == null)
			savedProduct = productRep.save(threadDto.product());
			
		UserEntity user = userRep.findById(logedUserId)
				.orElseThrow(() -> new AppException("Loged user not found", HttpStatus.NOT_FOUND));
		
		MyThread thread = MyThread.builder()
				.title(threadDto.title())
				.content(threadDto.content())
				.product(savedProduct)
				.user(user)
				.build();
		
		MyThread savedThread = threadRep.save(thread);
		ThreadDto savedThreadDto = ThreadDto.builder()
				.threadId(savedThread.getId())
				.product(savedProduct)
				.title(savedThread.getTitle())
				.content(savedThread.getContent())
				.build();
		
		return savedThreadDto;
	}

	@Override
	public ThreadDto updateThread(ThreadDto threadDto) {
		MyThread updatedThread = threadRep.findById(threadDto.threadId())
				.orElseThrow(() -> new AppException("Thread not found", HttpStatus.NOT_FOUND));
		return null;
	}

	@Override
	public void deleteThreadById(Long threadId) {
		
	}

	@Override
	public List<ThreadDto> readThreadsByUserId(Long threadId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ThreadDto> readThreadsByProductId(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ThreadDto readThreadById(Long threadId) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
