package com.example.demo.model.persist.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.AppException;
import com.example.demo.model.dto.ThreadDto;
import com.example.demo.model.entities.MyThread;
import com.example.demo.model.entities.Product;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.persist.dao.MyThreadDao;
import com.example.demo.model.persist.repository.MyThreadRepository;
import com.example.demo.model.persist.repository.ProductRepository;
import com.example.demo.model.persist.repository.UserRepository;

@Service
public class MyThreadDaoImpl implements MyThreadDao {
	
	@Autowired
	private MyThreadRepository threadRep;
	
	@Autowired
	private ProductRepository productRep;
	
	@Autowired
	private UserRepository userRep;
	
	@Override
	public MyThread createThread(ThreadDto threadDto, Long logedUserId) {
		
		Product savedProduct = productRep.findById(threadDto.id()).orElse(null);
		if (savedProduct == null)
			savedProduct = productRep.save(threadDto.product());
			
		UserEntity user = userRep.findById(logedUserId)
				.orElseThrow(() -> new AppException("Loged user not found", HttpStatus.NOT_FOUND));
		
		MyThread creatingThread = MyThread.builder()
				.title(threadDto.title())
				.content(threadDto.content())
				.product(savedProduct)
				.user(user)
				.build();
		
		MyThread savedThread = threadRep.save(creatingThread);
		return savedThread;
	}

	@Override
	public MyThread updateThread(ThreadDto threadDto) {
		
		MyThread savedThread = threadRep.findById(threadDto.id())
				.orElseThrow(() -> new AppException("Thread not found", HttpStatus.NOT_FOUND));
		savedThread.setTitle(threadDto.title());
		savedThread.setContent(threadDto.content());
		
		MyThread updatedThread = threadRep.save(savedThread);
		return updatedThread;
	}

	@Override
	public void deleteThreadById(Long threadId) {
		
		threadRep.findById(threadId)
			.orElseThrow(() -> new AppException("Thread not found", HttpStatus.NOT_FOUND));
		
		threadRep.deleteById(threadId);
	}

	@Override
	public List<MyThread> readThreadsByUserId(Long userId) {
		
		List<MyThread> userThreads = threadRep.findThreadsByUserId(userId);
		
		if (userThreads == null || userThreads.isEmpty())
			throw new AppException("No products found for this user.", HttpStatus.NO_CONTENT);

		return userThreads;
	}

	@Override
	public List<MyThread> readThreadsByProductId(Long productId) {
		
		List<MyThread> productThreads = threadRep.findThreadsByProductId(productId);
		
		if (productThreads == null || productThreads.isEmpty())
			throw new AppException("No products found for this user.", HttpStatus.NO_CONTENT);

		return productThreads;
	}

	@Override
	public MyThread readThreadById(Long threadId) {
		MyThread foundThread = threadRep.findById(threadId)
				.orElseThrow(() -> new AppException("Thread not found", HttpStatus.NOT_FOUND));
		
		return foundThread;
	}
	
}
