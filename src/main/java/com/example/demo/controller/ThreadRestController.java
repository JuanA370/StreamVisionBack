package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import com.example.demo.model.dto.ThreadDto;
import com.example.demo.model.dto.ThreadResponseDto;
import com.example.demo.model.entities.MyThread;
import com.example.demo.model.persist.dao.MyThreadDao;
import com.example.demo.model.services.ThreadDtoService;

@RestController
@RequestMapping(path = "/threads")
public class ThreadRestController {
	
	private final Long logedUserId = 1L;
	
	@Autowired
	private MyThreadDao threadDao;
	
	@Autowired
	private ThreadDtoService threadDtoService;

	@PostMapping(path = "/create",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createThread(@RequestBody ThreadDto threadDto){
		
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		
		try {
			MyThread createdThread = threadDao.createThread(threadDto, logedUserId);
			ThreadResponseDto createdThreadDto = threadDtoService.createThreadResponseDto(createdThread);
			responseContent.put("result", createdThreadDto);
			httpStatus = HttpStatus.CREATED;
		} catch (AppException e) {
			responseContent.put("message", e.getMessage());
			httpStatus = e.getHttpStatus();
		} catch (Exception e) {
			responseContent.put("message", "Error while creating thread: ".concat(e.getMessage()));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}
	
	@DeleteMapping(path = "/delete/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteThread(@PathVariable Long id){
		
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		
		try {
			threadDao.deleteThreadById(id);
			responseContent.put("message", "thread removed");
			httpStatus = HttpStatus.OK;
		} catch (AppException e) {
			responseContent.put("message", e.getMessage());
			httpStatus = e.getHttpStatus();
		} catch (Exception e) {
			responseContent.put("message", "Error while removing thread: ".concat(e.getMessage()));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}
	
	@PutMapping(path = "/update",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateThread(@RequestBody ThreadDto threadDto){
		
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		
		try {
			MyThread updatedThread = threadDao.updateThread(threadDto);
			ThreadResponseDto updatedThreadDto = threadDtoService.createThreadResponseDto(updatedThread);
			responseContent.put("result", updatedThreadDto);
			httpStatus = HttpStatus.CREATED;
		} catch (AppException e) {
			responseContent.put("message", e.getMessage());
			httpStatus = e.getHttpStatus();
		} catch (Exception e) {
			responseContent.put("message", "Error while updating thread: ".concat(e.getMessage()));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}
	
	@GetMapping(path = "/product/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> forumThreads(@PathVariable Long id){
		
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		
		try {
			List<MyThread> forumThreads = threadDao.readThreadsByProductId(id);
			List<ThreadResponseDto> forumThreadDtos = threadDtoService.threadListToThreadResponseDtoList(forumThreads);
			responseContent.put("result", forumThreadDtos);
			httpStatus = HttpStatus.OK;
		} catch (AppException e) {
			responseContent.put("message", e.getMessage());
			httpStatus = e.getHttpStatus();
		} catch (Exception e) {
			responseContent.put("message", "Error while updating thread: ".concat(e.getMessage()));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}
	
	@GetMapping(path= "/user/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> userThreads(@PathVariable Long id){
		
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		
		try {
			List<MyThread> userThreads = threadDao.readThreadsByUserId(id);
			List<ThreadResponseDto> userThreadDtos = threadDtoService.threadListToThreadResponseDtoList(userThreads);
			responseContent.put("result", userThreadDtos);
			httpStatus = HttpStatus.OK;
		} catch (AppException e) {
			responseContent.put("message", e.getMessage());
			httpStatus = e.getHttpStatus();
		} catch (Exception e) {
			responseContent.put("message", "Error while updating thread: ".concat(e.getMessage()));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}
	
	@GetMapping(path = "/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> threadById(@PathVariable Long id){
		
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		
		try {
			MyThread foundThread = threadDao.readThreadById(id);
			ThreadResponseDto foundThreadDto = threadDtoService.createThreadResponseDto(foundThread);
			responseContent.put("result", foundThreadDto);
			httpStatus = HttpStatus.OK;
		} catch (AppException e) {
			responseContent.put("message", e.getMessage());
			httpStatus = e.getHttpStatus();
		} catch (Exception e) {
			responseContent.put("message", "Error while updating thread: ".concat(e.getMessage()));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}
	
}
