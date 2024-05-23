package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.AppException;
import com.example.demo.model.dto.ReplyDto;
import com.example.demo.model.dto.ReplyResponseDto;
import com.example.demo.model.entities.Reply;
import com.example.demo.model.persist.dao.ReplyDao;
import com.example.demo.model.services.ReplyDtoService;

@RestController
@RequestMapping("/replies")
public class ReplyRestController {
	
	@Autowired
	private ReplyDao replyDao;
	
	@Autowired
	private ReplyDtoService replyDtoService;
	
	private final Long logedUserId = 1L;
	
	@GetMapping("/thread/{id}")
	public ResponseEntity<?> getThreadReplies(@PathVariable Long id){
		
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		
		try {
			List<Reply> threadReplies = replyDao.readRepliesByThreadId(id);
			List<ReplyResponseDto> threadReplieDtos = replyDtoService.replyListToReplyResponseDtoList(threadReplies);
			responseContent.put("result", threadReplieDtos);
			httpStatus = HttpStatus.OK;
		} catch (AppException e) {
			responseContent.put("message", e.getMessage());
			httpStatus = e.getHttpStatus();
		} catch (Exception e) {
			responseContent.put("message", "Error while reading replies: ".concat(e.getMessage()));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserReplies(@PathVariable Long id){
		
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		
		try {
			List<Reply> userReplies = replyDao.readRepliesByUserId(id);
			List<ReplyResponseDto> userReplyDtos = replyDtoService.replyListToReplyResponseDtoList(userReplies);
			responseContent.put("result", userReplyDtos);
			httpStatus = HttpStatus.OK;
		} catch (AppException e) {
			responseContent.put("message", e.getMessage());
			httpStatus = e.getHttpStatus();
		} catch (Exception e) {
			responseContent.put("message", "Error while reading replies: ".concat(e.getMessage()));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}
	
	@PostMapping
	public ResponseEntity<?> createReply(@RequestBody ReplyDto replyDto){
		
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		
		try {
			Reply createdReply = replyDao.createReply(replyDto, logedUserId);
			ReplyResponseDto createdReplyDto = replyDtoService.createReplyResponseDto(createdReply); 
			responseContent.put("result", createdReplyDto);
			httpStatus = HttpStatus.OK;
		} catch (AppException e) {
			responseContent.put("message", e.getMessage());
			httpStatus = e.getHttpStatus();
		} catch (Exception e) {
			responseContent.put("message", "Error while reading replies: ".concat(e.getMessage()));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteReply(@PathVariable Long id){
		
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		
		try {
			replyDao.deleteReplyById(id);
			responseContent.put("message", "Reply removed");
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			responseContent.put("message", "Error while removing thread: ".concat(e.getMessage()));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}
	
	@PutMapping
	public ResponseEntity<?> updateReply(@RequestBody ReplyDto replyDto){
		
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		
		try {
			Reply updatedReply = replyDao.updateReply(replyDto);
			ReplyResponseDto updatedReplyDto = replyDtoService.createReplyResponseDto(updatedReply);
			responseContent.put("result", updatedReplyDto);
			httpStatus = HttpStatus.CREATED;
		} catch (AppException e) {
			responseContent.put("message", e.getMessage());
			httpStatus = e.getHttpStatus();
		} catch (Exception e) {
			responseContent.put("message", "Error while updating reply: ".concat(e.getMessage()));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}

}
