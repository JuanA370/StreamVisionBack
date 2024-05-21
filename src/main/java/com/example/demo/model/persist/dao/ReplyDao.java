package com.example.demo.model.persist.dao;

import java.util.List;

import com.example.demo.model.entities.Reply;

public interface ReplyDao {

	public Reply saveReply(Reply reply);
	
	public void deleteReply(Reply reply);
	
	public List<Reply> listReply(long userId);
	
	public List<Reply> searchReply(Long userId, Long threadId, Long productId);
	
}
