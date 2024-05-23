package com.example.demo.model.persist.repository;
	
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

	@Query("SELECT p FROM Post p WHERE p.user.id =?1")
	public List<Post> findPostsByUserId(Long userId);
	
	@Query("SELECT p FROM Post p WHERE p.product.id =?1 AND p.repliedPost IS NULL")
	public List<Post> findPostsByProductId(Long productId);
	
	@Query("SELECT p FROM Post p WHERE p.repliedPost.id =?1")
	public List<Post> findRepliesByPostId(Long postId);
	
}