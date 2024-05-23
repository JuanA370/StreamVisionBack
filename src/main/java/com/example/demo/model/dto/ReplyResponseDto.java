package com.example.demo.model.dto;

import java.util.Date;

import lombok.Builder;

@Builder
public class ReplyResponseDto {

	private Long replyId;
	private Long threadId;
	private String author;
	private Date replyDate;
	private String content;
	
}