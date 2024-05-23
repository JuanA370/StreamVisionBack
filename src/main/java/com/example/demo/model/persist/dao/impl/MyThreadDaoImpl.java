package com.example.demo.model.persist.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

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
	public ThreadDto createThread(ThreadDto threadDto, Long logedUserId) {
		
		Product savedProduct = productRep.findById(threadDto.id()).orElse(null);
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
				.id(savedThread.getId())
				.product(savedProduct)
				.title(savedThread.getTitle())
				.content(savedThread.getContent())
				.author(user.getUsername())
				.build();
		
		return savedThreadDto;
	}

	@Override
	public ThreadDto updateThread(ThreadDto threadDto) {
		
		MyThread savedThread = threadRep.findById(threadDto.id())
				.orElseThrow(() -> new AppException("Thread not found", HttpStatus.NOT_FOUND));
		savedThread.setTitle(threadDto.title());
		savedThread.setContent(threadDto.content());
		
		MyThread updatedThread = threadRep.save(savedThread);
		ThreadDto updatedThreadDto = ThreadDto.builder()
				.id(updatedThread.getId())
				.title(updatedThread.getTitle())
				.content(updatedThread.getContent())
				.author(updatedThread.getUser().getUsername())
				.build();
		
		return updatedThreadDto;
	}

	@Override
	public void deleteThreadById(Long threadId) {
		threadRep.deleteById(threadId);
	}

	@Override
	public List<ThreadDto> readThreadsByUserId(Long userId) {
		
		List<MyThread> userThreads = threadRep.findThreadsByUserId(userId);
		
		if (userThreads == null || userThreads.isEmpty())
			throw new AppException("No products found for this user.", HttpStatus.NO_CONTENT);
		
		List<ThreadDto> userThreadDtos = userThreads
				.stream().map(thread -> ThreadDto.builder()
						.id(thread.getId())
						.title(thread.getTitle())
						.content(thread.getContent())
						.author(thread.getUser().getUsername())
						.build())
				.collect(Collectors.toList()); 

		return userThreadDtos;
	}

	@Override
	public List<ThreadDto> readThreadsByProductId(Long productId) {
		
		List<MyThread> productThreads = threadRep.findThreadsByProductId(productId);
		
		if (productThreads == null || productThreads.isEmpty())
			throw new AppException("No products found for this user.", HttpStatus.NO_CONTENT);
		
		List<ThreadDto> productThreadDtos = productThreads
				.stream().map(thread -> ThreadDto.builder()
						.id(thread.getId())
						.title(thread.getTitle())
						.content(thread.getContent())
						.author(thread.getUser().getUsername())
						.build())
				.collect(Collectors.toList()); 

		return productThreadDtos;
	}

	@Override
	public ThreadDto readThreadById(Long threadId) {
		MyThread thread = threadRep.findById(threadId)
				.orElseThrow(() -> new AppException("Thread not found", HttpStatus.NOT_FOUND));
		
		ThreadDto threadDto = ThreadDto.builder()
				.id(threadId)
				.title(thread.getTitle())
				.content(thread.getContent())
				.author(thread.getUser().getUsername())
				.build();
		
		return threadDto;
	}
	
}
