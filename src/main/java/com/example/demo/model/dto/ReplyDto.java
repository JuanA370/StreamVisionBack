package com.example.demo.model.dto;

import lombok.Builder;

@Builder
public record ReplyDto (
	
		Long replyId,
		Long threadId,
		String author,
		String content
		
) { }