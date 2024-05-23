package com.example.demo.model.persist.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.AppException;
import com.example.demo.model.dto.ReplyDto;
import com.example.demo.model.entities.MyThread;
import com.example.demo.model.entities.Reply;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.persist.dao.ReplyDao;
import com.example.demo.model.persist.repository.MyThreadRepository;
import com.example.demo.model.persist.repository.ReplyRepository;
import com.example.demo.model.persist.repository.UserRepository;

@Service
public class ReplyDaoImpl implements ReplyDao{

	@Autowired
	private ReplyRepository replyRep;
	
	@Autowired
	private MyThreadRepository threadRep;
	
	@Autowired
	private UserRepository userRep;

	@Override
	public Reply createReply(ReplyDto replyDto, Long logedUserId) {
		
		UserEntity user = userRep.findById(logedUserId)
				.orElseThrow(() -> new AppException("Loged user not found", HttpStatus.NOT_FOUND));
		
		MyThread thread = threadRep.findById(replyDto.replyId())
				.orElseThrow(() -> new AppException("Thread not found", HttpStatus.NOT_FOUND));
		
		Reply reply = Reply.builder()
				.user(user)
				.thread(thread)
				.content(replyDto.content())
				.build();
		
		Reply createdReply = replyRep.save(reply); 
		return createdReply;
	}

	@Override
	public Reply updateReply(ReplyDto replyDto) {
		
		Reply savedReply = replyRep.findById(replyDto.replyId())
				.orElseThrow(() -> new AppException("Could not find original reply", HttpStatus.NOT_FOUND));
		
		savedReply.setContent(replyDto.content());
		Reply updatedReply = replyRep.save(savedReply);
		return updatedReply;
	}

	@Override
	public void deleteReplyById(Long replyId) {
		
		replyRep.findById(replyId).orElseThrow(() -> new AppException("Reply not found", HttpStatus.NOT_FOUND));
		replyRep.deleteById(replyId);
	}

	@Override
	public List<Reply> readRepliesByUserId(Long userId) {
		
		List<Reply> userReplies = replyRep.findRepliesByUserId(userId);
		if (userReplies == null || userReplies.isEmpty())
			throw new AppException("No replies found", HttpStatus.NO_CONTENT);
		
		return userReplies;
	}

	@Override
	public List<Reply> readRepliesByThreadId(Long threadId) {
		
		List<Reply> threadReplies = replyRep.findRepliesByThreadId(threadId);
		if (threadReplies == null || threadReplies.isEmpty())
			throw new AppException("No replies found", HttpStatus.NO_CONTENT);
		
		return threadReplies;
	}
	

}