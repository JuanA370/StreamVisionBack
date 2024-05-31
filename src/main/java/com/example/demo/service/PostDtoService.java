package com.example.demo.service;


import java.sql.Timestamp;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.PostResponseDto;
import com.example.demo.model.entities.Post;

@Service
public class PostDtoService {

	public PostResponseDto createPostResponseDto(Post post) {
		
		Timestamp currentDate = new Timestamp(System.currentTimeMillis());
		PostResponseDto postResponseDto = PostResponseDto.builder()
				.localRating(post.getLocalRating())
				.content(post.getContent())
				.author(post.getUser().getUsername())
				.postDate(currentDate)
				.build();
		return postResponseDto;
	}
	
	public Page<PostResponseDto> postListToPostResponseDtoList(Page<Post> posts) {
		
		Page<PostResponseDto> postResponseDtos = posts
				.map(post -> createPostResponseDto(post)); 
		return postResponseDtos;
	}
	
}