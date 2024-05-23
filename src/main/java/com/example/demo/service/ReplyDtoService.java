package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ReplyResponseDto;
import com.example.demo.model.entities.Reply;

@Service
public class ReplyDtoService {

	public ReplyResponseDto createReplyResponseDto(Reply reply) {
		ReplyResponseDto threadResponseDto = ReplyResponseDto.builder()
				.replyId(reply.getId())
				.threadId(reply.getId())
				.author(reply.getUser().getUsername())
				.replyDate(reply.getReplyDate())
				.content(reply.getContent())
				.build();
				
		return threadResponseDto;
	}
	
	public List<ReplyResponseDto> replyListToReplyResponseDtoList(List<Reply> replies) {
		List<ReplyResponseDto> replyResponseDtos = replies.stream()
				.map(reply -> createReplyResponseDto(reply)).collect(Collectors.toList()); 
		return replyResponseDtos;
	}
}