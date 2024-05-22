package com.example.demo.model.persist.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.AppException;
import com.example.demo.model.entities.Product;
import com.example.demo.model.entities.Purchase;
import com.example.demo.model.entities.PurchasePk;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.persist.dao.PurchaseDao;
import com.example.demo.model.persist.repository.ProductRepository;
import com.example.demo.model.persist.repository.PurchaseRepository;
import com.example.demo.model.persist.repository.UserRepository;

@Service
public class PurchaseDaoImpl implements PurchaseDao {
	
	@Autowired
	private PurchaseRepository purchaseRep;
	
	@Autowired
	private UserRepository userRep;
	
	@Autowired
	private ProductRepository productRep;
	
	//CREAR COMPRA
	@Override
	public Purchase createPurchase(Product product, Long logedUserId) {
		Purchase inProgressPurchase = null;
		Purchase createdPurchase = null;
		Product savedProduct = null;
		PurchasePk purchasePk = new PurchasePk(product.getId(), logedUserId);
		try {
			if (purchaseRep.findPurchaseByPurchasePk(purchasePk) != null)
				throw new AppException("You have already bought this product", HttpStatus.LOCKED);
			else {
				savedProduct = productRep.findById(product.getId()).orElse(null);
				if (savedProduct == null) 
					savedProduct = productRep.save(product);
				UserEntity user = userRep.findById(logedUserId)
						.orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
				inProgressPurchase = Purchase.builder()
				.purchasePk(purchasePk)
				.product(savedProduct)
				.user(user)
				.build();
				//Lanza una excepción si no consigue almacenar la entidad, no como findbyid
				createdPurchase = purchaseRep.save(inProgressPurchase);
			}
		} catch (Exception e) {
			throw new AppException("Error while purchasing", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return createdPurchase;
	}
	
	@Override
	public List<Product> readPurchasesByUserId(Long userId) {
		List<Product> purchasedProducts;
		purchasedProducts = purchaseRep.findPurchasedProductsByUserId(userId);
		if (purchasedProducts.isEmpty())
			throw new AppException("No products found for this user.", HttpStatus.NOT_FOUND);
		return purchasedProducts;
	}

}


