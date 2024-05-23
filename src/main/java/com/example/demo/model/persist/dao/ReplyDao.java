package com.example.demo.model.persist.dao;

import java.util.List;

import com.example.demo.model.dto.ReplyDto;
import com.example.demo.model.entities.Reply;

public interface ReplyDao {

	public Reply createReply(ReplyDto replyDto, Long logedUserId);
	
	public Reply updateReply(ReplyDto replydto);
	
	public void deleteReplyById(Long replyId);
	
	public List<Reply> readRepliesByUserId(Long userId);
	
	public List<Reply> readRepliesByThreadId(Long threadId);
	
}