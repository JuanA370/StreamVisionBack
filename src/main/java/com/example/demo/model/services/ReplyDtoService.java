package com.example.demo.model.services;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.model.dto.ReplyResponseDto;
import com.example.demo.model.entities.Reply;

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