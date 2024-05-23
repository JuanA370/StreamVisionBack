package com.example.demo.model.persist.dao;

import java.util.List;

import com.example.demo.model.dto.PostDto;
import com.example.demo.model.entities.Post;

public interface PostDao {

	public Post createPost (PostDto postDto, Long logedUserId);
	
	public Post updatePost (PostDto postDto);
	
	public void deletePostById(Long postId);
	
	public List<Post> readPostsByUserId(Long userId);
	
	public List<Post> readPostsByProductId(Long productId);
	
	public List<Post> readRepliesByPostId(Long postId);
	
	public Post readPostById(Long threadId);
	
}