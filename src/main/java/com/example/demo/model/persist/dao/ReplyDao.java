package com.example.demo.model.persist.dao;

import java.util.List;

import com.example.demo.model.entities.Reply;

public interface ReplyDao {

	public Reply createReply(Reply reply);
	
	public void deleteReply(Reply reply);
	
	public List<Reply> readRepliesByUserId(long userId);
	
	public List<Reply> readRepliesByReplyPk(Long userId, Long threadId, Long productId);
	
}
