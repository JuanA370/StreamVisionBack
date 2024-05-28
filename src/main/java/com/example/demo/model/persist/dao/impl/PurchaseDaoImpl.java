package com.example.demo.model.persist.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.AppException;
import com.example.demo.model.dto.InteractionDto;
import com.example.demo.model.entities.Product;
import com.example.demo.model.entities.Purchase;
import com.example.demo.model.entities.PurchasePk;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.persist.dao.PurchaseDao;
import com.example.demo.model.persist.repository.ProductRepository;
import com.example.demo.model.persist.repository.PurchaseRepository;
import com.example.demo.model.persist.repository.UserRepository;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.service.ProducExtractService;

@Service
public class PurchaseDaoImpl implements PurchaseDao {

	@Autowired
	private PurchaseRepository purchaseRep;

	@Autowired
	private UserRepository userRep;

	@Autowired
	private ProductRepository productRep;
	
	@Autowired
	private JwtUtils jwtUtils;
	@Autowired
	private ProducExtractService productService;

	// CREAR COMPRA
	@Override
	public Purchase createPurchase(InteractionDto interactDto, String token) {
		
		token = token.substring(7);
		Long loggedUserId = jwtUtils.getUserIdFromToken(token);
		
		Product product = productRep.findProductByIsFilmAndTmdbId(interactDto.isFilm(), interactDto.tmdbId());
		if (product == null) {
			Product createdProduct = productService.extractProductFromTmdbJsonApi(interactDto);
			product = productRep.save(createdProduct);
		}
		
		PurchasePk purchasePk = new PurchasePk(loggedUserId, product.getProductId());
		Purchase savedPurchase = purchaseRep.findPurchaseByPurchasePk(purchasePk);
		if (savedPurchase != null)
			throw new AppException("You have already bought this product", HttpStatus.LOCKED);

		UserEntity user = userRep.findById(loggedUserId)
				.orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
		
		user.setCoins(user.getCoins() + 100);
		Purchase purchase = Purchase.builder()
				.purchasePk(purchasePk)
				.product(product)
				.user(user)
				.build();
		
		Purchase createdPurchase = purchaseRep.save(purchase);
		return createdPurchase;
	}
	
	

	@Override
	public List<Product> readPurchasesByUserId(String token) {
		
		token = token.substring(7);
		Long userId = jwtUtils.getUserIdFromToken(token);
		
		List<Product> purchasedProducts = purchaseRep.findPurchasedProductsByUserId(userId);
		
		return purchasedProducts;
	}

}
