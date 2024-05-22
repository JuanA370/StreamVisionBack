package com.example.demo.model.persist.dao;

import java.util.List;

import com.example.demo.model.dto.ThreadDto;

public interface MyThreadDao {

	public ThreadDto createThread (ThreadDto threadDto, Long logedUserId);
	
	public ThreadDto updateThread (ThreadDto threadDto);
	
	public void deleteThreadById(Long threadId);
	
	public List<ThreadDto> readThreadsByUserId(Long userId);
	
	public List<ThreadDto> readThreadsByProductId(Long productId);
	
	public ThreadDto readThreadById(Long threadId);
	
}