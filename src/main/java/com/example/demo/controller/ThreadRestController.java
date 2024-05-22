package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.ThreadDto;

@RestController
@RequestMapping(path = "/threads")
public class ThreadRestController {

	@PostMapping(path = "/create")
	public ResponseEntity<?> createThread(@RequestBody ThreadDto Thread){
		return null;
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<?> deleteThread(@PathVariable Long id){
		return null;
	}
	
	@GetMapping(path = "/product/{id}")
	public ResponseEntity<?> forumThreads(@PathVariable Long id){
		return null;
	}
	
	@GetMapping(path= "/user/{id}")
	public ResponseEntity<?> userThreads(@PathVariable Long id){
		return null;
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> threadById(@PathVariable Long id){
		return null;
	}
}
