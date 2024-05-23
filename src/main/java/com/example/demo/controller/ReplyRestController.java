package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.AppException;
import com.example.demo.model.dto.ReplyDto;
import com.example.demo.model.persist.dao.ReplyDao;

@RestController
@RequestMapping("/replies")
public class ReplyRestController {
	
	@Autowired
	private ReplyDao replyDao;
	
	private final Long logedUserId = 1L;
	
	@GetMapping("/thread/{id}")
	public ResponseEntity<?> getThreadReplies(@PathVariable Long id){
		
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		
		try {
			List<ReplyDto> threadReplies = replyDao.readRepliesByThreadId(id);
			responseContent.put("threadReplies", threadReplies);
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
			List<ReplyDto> userReplies = replyDao.readRepliesByUserId(id);
			responseContent.put("userReplies", userReplies);
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
	
	@GetMapping("/create")
	public ResponseEntity<?> createReply(@RequestBody ReplyDto replyDto){
		
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		
		try {
			ReplyDto createdReply = replyDao.createReply(replyDto, logedUserId);
			responseContent.put("createdReply", createdReply);
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
	
	@GetMapping("/delete/{id}")
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
	
	@GetMapping("/update")
	public ResponseEntity<?> getThreadReplies(@RequestBody ReplyDto replyDto){
		
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		
		try {
			ReplyDto updatedReply = replyDao.updateReply(replyDto);
			responseContent.put("updatedReply", updatedReply);
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
