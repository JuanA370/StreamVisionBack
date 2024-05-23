package com.example.demo.model.persist.dao;

import java.util.List;

import com.example.demo.model.dto.ReplyDto;
import com.example.demo.model.entities.Reply;

public interface ReplyDao {

	public ReplyDto createReply(ReplyDto replyDto, Long logedUserId);
	
	public ReplyDto updateReply(ReplyDto replydto);
	
	public void deleteReplyById(Long replyId);
	
	public List<ReplyDto> readRepliesByUserId(Long userId);
	
	public List<ReplyDto> readRepliesByThreadId(Long threadId);
	
}