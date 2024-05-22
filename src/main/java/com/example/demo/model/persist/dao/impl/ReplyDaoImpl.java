package com.example.demo.model.persist.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

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
	public ReplyDto createReply(ReplyDto replyDto, Long logedUserId) {
		
		UserEntity user = userRep.findById(logedUserId)
				.orElseThrow(() -> new AppException("Loged user not found", HttpStatus.NOT_FOUND));
		
		MyThread thread = threadRep.findById(replyDto.replyId())
				.orElseThrow(() -> new AppException("Thread not found", HttpStatus.NOT_FOUND));
		
		Reply reply = Reply.builder()
				.user(user)
				.thread(thread)
				.content(replyDto.content())
				.build();
		
		replyRep.save(reply); 
		return replyDto;
	}

	@Override
	public ReplyDto updateReply(ReplyDto replyDto) {
		
		Reply savedReply = replyRep.findById(replyDto.replyId())
				.orElseThrow(() -> new AppException("Could not find original reply", HttpStatus.NOT_FOUND));
		
		savedReply.setContent(replyDto.content());
		replyRep.save(savedReply);
		return replyDto;
	}

	@Override
	public void deleteReplyById(Long replyId) {
		replyRep.deleteById(replyId);
	}

	@Override
	public List<ReplyDto> readRepliesByUserId(Long userId) {
		
		List<Reply> userReplies = replyRep.findRepliesByUserId(userId);
		if (userReplies == null || userReplies.isEmpty())
			throw new AppException("No replies found", HttpStatus.NO_CONTENT);
		
		List<ReplyDto> userReplyDtos = userReplies.stream()
				.map(reply -> ReplyDto.builder()
						.content(reply.getContent())
						.author(reply.getUser().getUsername())
						.build())
				.collect(Collectors.toList());
		
		return userReplyDtos;
	}

	@Override
	public List<ReplyDto> readRepliesByThreadId(Long threadId) {
		
		List<Reply> threadReplies = replyRep.findRepliesByThreadId(threadId);
		if (threadReplies == null || threadReplies.isEmpty())
			throw new AppException("No replies found", HttpStatus.NO_CONTENT);
		
		List<ReplyDto> threadReplyDtos = threadReplies.stream()
				.map(reply -> ReplyDto.builder()
						.content(reply.getContent())
						.author(reply.getUser().getUsername())
						.build())
				.collect(Collectors.toList());
		
		return threadReplyDtos;
	}
	

}