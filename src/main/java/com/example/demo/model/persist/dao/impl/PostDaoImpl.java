package com.example.demo.model.persist.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import com.example.demo.security.jwt.JwtUtils;

@Service
public class PostDaoImpl implements PostDao {
	
	@Autowired
	private PostRepository postRep;
	
	@Autowired
	private ProductRepository productRep;
	
	@Autowired
	private UserRepository userRep;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Override
	public Post createPost(PostDto postDto, String token) {
		Post repliedPost = null;
		token = token.substring(7);
		Long loggedUserId = jwtUtils.getUserIdFromToken(token);
		Product savedProduct = productRep.findById(postDto.product().getProductId()).orElse(null);
		if (savedProduct == null)
				savedProduct = productRep.save(postDto.product());

		UserEntity user = userRep.findById(loggedUserId)
				.orElseThrow(() -> new AppException("Logged user not found", HttpStatus.NOT_FOUND));
		
		if (postDto.repliedPostId() != null)
			repliedPost = postRep.findById(postDto.repliedPostId())
					.orElseThrow(() -> new AppException("Logged user not found", HttpStatus.NOT_FOUND));
		
		Post creatingThread = Post.builder()
				.title(postDto.title())
				.content(postDto.content())
				.repliedPost(repliedPost)
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
	public Page<Post> readRepliesByPostId(Pageable pageable, Long postId) {
		
		Page<Post> postReplies = postRep.findRepliesByPostId(pageable, postId);

		return postReplies;
	}

	@Override
	public Page<Post> readPostsByUserId(Pageable pageable, Long userId) {
		
		Page<Post> userPosts = postRep.findPostsByUserId(pageable, userId);

		return userPosts;
	}

	@Override
	public Page<Post> readPostsByProductId(Pageable pageable, Long productId) {
		
		Page<Post> productPosts = postRep.findPostsByProductId(pageable, productId);

		return productPosts;
	}

	@Override
	public Post readPostById(Long postId) {
		
		Post foundPost = postRep.findById(postId)
				.orElseThrow(() -> new AppException("Post not found", HttpStatus.NOT_FOUND));
		
		return foundPost;
	}
	
}
