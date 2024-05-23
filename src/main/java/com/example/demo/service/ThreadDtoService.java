package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ThreadResponseDto;
import com.example.demo.model.entities.MyThread;

@Service
public class ThreadDtoService {

	public ThreadResponseDto createThreadResponseDto(MyThread thread) {
		ThreadResponseDto threadResponseDto = ThreadResponseDto.builder()
				.id(thread.getId())
				.title(thread.getTitle())
				.content(thread.getContent())
				.author(thread.getUser().getUsername())
				.build();
		return threadResponseDto;
	}
	
	public List<ThreadResponseDto> threadListToThreadResponseDtoList(List<MyThread> threads) {
		List<ThreadResponseDto> threadResponseDtos = threads.stream()
				.map(thread -> createThreadResponseDto(thread)).collect(Collectors.toList()); 
		return threadResponseDtos;
	}
	
}