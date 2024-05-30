package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.PostResponseDto;
import com.example.demo.model.entities.Post;

@Service
public class PostDtoService {

	public PostResponseDto createPostResponseDto(Post post) {
		
		PostResponseDto postResponseDto = PostResponseDto.builder()
				.id(post.getId())
				.localRating(post.getLocalRating())
				.content(post.getContent())
				.author(post.getUser().getUsername())
				.build();
		return postResponseDto;
	}
	
	public Page<PostResponseDto> postListToPostResponseDtoList(Page<Post> posts) {
		
		Page<PostResponseDto> postResponseDtos = posts
				.map(post -> createPostResponseDto(post)); 
		return postResponseDtos;
	}
	
}