package com.example.demo.model.persist.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

	@Query(value = "SELECT r from Reply r where r.user.id = ?1")
	public List<Reply> findRepliesByUserId(Long userId);

	@Query(value = "SELECT r from Reply r WHERE r.thread.id = ?1")
	public List<Reply> findRepliesByThreadId(Long threadId);

}