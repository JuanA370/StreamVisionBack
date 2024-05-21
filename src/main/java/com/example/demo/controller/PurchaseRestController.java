package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entities.Purchase;
import com.example.demo.exceptions.AppException;
import com.example.demo.model.entities.Product;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.persist.dao.PurchaseDao;
import com.example.demo.model.service.PurchasingService;

@RestController
@RequestMapping("/purchase")
public class PurchaseRestController {
	
	@Autowired
	private PurchaseDao purchaseDao;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> purchase(@RequestBody Purchase purchase) {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		Purchase savedPurchase = null;
		try {
			savedPurchase = purchaseDao.createPurchase(purchase);
		}catch (AppException e) {
			responseContent.put("message", e.getMessage());
			response = new ResponseEntity<Map<String, Object>>(responseContent,e.getHttpStatus());
		}
		response = new ResponseEntity<Purchase>(savedPurchase, HttpStatus.OK);
		return response;
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findProducts() {
		ResponseEntity<?> response;
		Map<String, Object> responseContent = new HashMap<>();
		List<Product> savedPurchases = null;
		try {
			savedPurchases = purchaseDao.readPurchasesByUserId(1L);
		} catch(AppException e) {
			responseContent.put("message", e.getMessage());
			response = new ResponseEntity<Map<String, Object>>(responseContent,e.getHttpStatus());
		}
		response = new ResponseEntity<List<Product>>(savedPurchases, HttpStatus.OK);
		return response;
	}
}
