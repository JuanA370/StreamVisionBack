package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entities.Purchase;
import com.example.demo.exceptions.AppException;
import com.example.demo.model.dto.InteractDto;
import com.example.demo.model.entities.Product;
import com.example.demo.model.persist.dao.PurchaseDao;

@RestController
@RequestMapping("/purchases")
public class PurchaseRestController {
	
	private final Long logedUserId = 1L;
	
	@Autowired
	private PurchaseDao purchaseDao;
	
	//REGISTRAR UNA COMPRA
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> purchase(@RequestBody InteractDto interactDto ,@RequestHeader("Authorization") String token) {
		
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		
		try {
			token = token.substring(7);
			Purchase savedPurchase = purchaseDao.createPurchase(interactDto, token);
			responseContent.put("result", savedPurchase);
			httpStatus = HttpStatus.ACCEPTED;
		} catch (AppException e) {
			responseContent.put("message", e.getMessage());
			httpStatus = e.getHttpStatus();
		} catch (Exception e) {
			responseContent.put("message", "Error while purchasing: ".concat(e.getMessage()));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findProducts() {
		
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		HttpStatus httpStatus;
		
		try {
			List<Product> purchasedProducts = purchaseDao.readPurchasesByUserId(logedUserId);
			responseContent.put("result", purchasedProducts);
			httpStatus = HttpStatus.OK;
		} catch (AppException e) {
			responseContent.put("message", e.getMessage());
			httpStatus = e.getHttpStatus();
		} catch (Exception e) {
			responseContent.put("message", "Error while purchasing: ".concat(e.getMessage()));
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}
}
