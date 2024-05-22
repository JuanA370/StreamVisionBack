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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entities.Purchase;
import com.example.demo.exceptions.AppException;
import com.example.demo.model.entities.Product;
import com.example.demo.model.persist.dao.PurchaseDao;

@RestController
@RequestMapping("/purchase")
public class PurchaseRestController {
	
	private final Long logedUserId = 1L;
	
	@Autowired
	private PurchaseDao purchaseDao;
	
	//REGISTRAR UNA COMPRA
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> purchase(@RequestBody Product product) {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		Purchase savedPurchase = null;
		HttpStatus httpStatus;
		try {
			savedPurchase = purchaseDao.createPurchase(product, logedUserId);
		}catch (AppException e) {
			responseContent.put("message", e.getMessage());
			httpStatus = e.getHttpStatus();
		}
		responseContent.put("savedPurchase", savedPurchase);
		httpStatus = HttpStatus.ACCEPTED;
		
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findProducts() {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		List<Product> savedPurchases = null;
		HttpStatus httpStatus;
		try {
			savedPurchases = purchaseDao.readPurchasesByUserId(logedUserId);
		} catch(AppException e) {
			responseContent.put("message", e.getMessage());
			httpStatus = e.getHttpStatus();
		}
		responseContent.put("savedPurchases",savedPurchases);
		httpStatus = HttpStatus.OK;
		response = new ResponseEntity<Map<String, Object>>(responseContent, httpStatus);
		return response;
	}
}
