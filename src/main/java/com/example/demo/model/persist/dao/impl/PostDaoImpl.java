package com.example.demo.model.persist.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.AppException;
import com.example.demo.model.dto.PostDto;
import com.example.demo.model.entities.Post;
import com.example.demo.model.entities.Product;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.persist.dao.PostDao;
import com.example.demo.model.persist.repository.PostRepository;
import com.example.demo.model.persist.repository.ProductRepository;
import com.example.demo.model.persist.repository.UserRepository;

@Service
public class PostDaoImpl implements PostDao {
	
	@Autowired
	private PostRepository postRep;
	
	@Autowired
	private ProductRepository productRep;
	
	@Autowired
	private UserRepository userRep;
	
	@Override
	public Post createPost(PostDto postDto, Long logedUserId) {

		Product savedProduct = productRep.findById(postDto.product().getId()).orElse(null);
		if (savedProduct == null)
				savedProduct = productRep.save(postDto.product());

		UserEntity user = userRep.findById(logedUserId)
				.orElseThrow(() -> new AppException("Loged user not found", HttpStatus.NOT_FOUND));
		
		Post creatingThread = Post.builder()
				.title(postDto.title())
				.content(postDto.content())
				.product(savedProduct)
				.user(user)
				.build();
		
		Post savedThread = postRep.save(creatingThread);
		return savedThread;
	}

	@Override
	public Post updatePost(PostDto postDto) {
		
		Post savedPost = postRep.findById(postDto.id())
				.orElseThrow(() -> new AppException("Post not found", HttpStatus.NOT_FOUND));
		savedPost.setTitle(postDto.title());
		savedPost.setContent(postDto.content());
		
		Post updatedPost = postRep.save(savedPost);
		return updatedPost;
	}

	@Override
	public void deletePostById(Long threadId) {
		
		postRep.findById(threadId)
			.orElseThrow(() -> new AppException("Post not found", HttpStatus.NOT_FOUND));
		
		postRep.deleteById(threadId);
	}
	
	@Override
	public List<Post> readRepliesByPostId(Long postId) {
		
		List<Post> postReplies = postRep.findRepliesByPostId(postId);
		
		if (postReplies == null || postReplies.isEmpty())
			throw new AppException("No replies found for the post", HttpStatus.NO_CONTENT);

		return postReplies;
	}

	@Override
	public List<Post> readPostsByUserId(Long userId) {
		
		List<Post> userPosts = postRep.findPostsByUserId(userId);
		
		if (userPosts == null || userPosts.isEmpty())
			throw new AppException("No posts aviables", HttpStatus.NO_CONTENT);

		return userPosts;
	}

	@Override
	public List<Post> readPostsByProductId(Long productId) {
		
		List<Post> productPosts = postRep.findPostsByProductId(productId);
		
		if (productPosts == null || productPosts.isEmpty())
			throw new AppException("No posts aviables", HttpStatus.NO_CONTENT);

		return productPosts;
	}

	@Override
	public Post readPostById(Long postId) {
		
		Post foundPost = postRep.findById(postId)
				.orElseThrow(() -> new AppException("Post not found", HttpStatus.NOT_FOUND));
		
		return foundPost;
	}
	
}
