package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.PostResponseDto;
import com.example.demo.model.entities.Post;

@Service
public class PostDtoService {

	public PostResponseDto createPostResponseDto(Post post) {
		
		PostResponseDto threadResponseDto = PostResponseDto.builder()
				.id(post.getId())
				.title(post.getTitle())
				.content(post.getContent())
				.author(post.getUser().getUsername())
				.build();
		return threadResponseDto;
	}
	
	public Page<PostResponseDto> postListToPostResponseDtoList(Page<Post> posts) {
		
		Page<PostResponseDto> threadResponseDtos = posts
				.map(thread -> createPostResponseDto(thread)); 
		return threadResponseDtos;
	}
	
}