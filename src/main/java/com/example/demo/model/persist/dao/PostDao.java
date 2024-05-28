package com.example.demo.model.persist.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.dto.PostDto;
import com.example.demo.model.entities.Post;

public interface PostDao {

	public Post createPost (PostDto postDto, Long loggedUserId);
	
	public Post updatePost (PostDto postDto);
	
	public void deletePostById(Long postId);
	
	public Page<Post> readPostsByUserId(Pageable pageable, Long userId);
	
	public Page<Post> readPostsByProductId(Pageable pageable, Long productId);
	
	public Page<Post> readRepliesByPostId(Pageable pageable, Long postId);
	
	public Post readPostById(Long postId);
	
}