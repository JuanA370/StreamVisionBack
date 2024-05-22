package com.example.demo.model.dto;

import com.example.demo.model.entities.Product;

public record ReplyDto (
	
		Long replyId,
		Long threadId,
		Product product,
		String content
		
) { }