package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.model.dto.PostResponseDto;
import com.example.demo.model.entities.Post;

@Service
public class PostDtoService {

	public PostResponseDto createPostResponseDto(Post thread) {
		PostResponseDto threadResponseDto = PostResponseDto.builder()
				.id(thread.getId())
				.title(thread.getTitle())
				.content(thread.getContent())
				.author(thread.getUser().getUsername())
				.build();
		return threadResponseDto;
	}
	
	public List<PostResponseDto> postListToPostResponseDtoList(List<Post> threads) {
		List<PostResponseDto> threadResponseDtos = threads.stream()
				.map(thread -> createPostResponseDto(thread)).collect(Collectors.toList()); 
		return threadResponseDtos;
	}
	
}