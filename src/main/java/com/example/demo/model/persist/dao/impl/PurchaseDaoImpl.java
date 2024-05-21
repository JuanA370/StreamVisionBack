package com.example.demo.model.persist.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entities.Product;
import com.example.demo.model.entities.Purchase;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.persist.dao.PurchaseDao;
import com.example.demo.model.persist.repository.PurchaseRepository;

@Service
public class PurchaseDaoImpl implements PurchaseDao {
	
	@Autowired
	private PurchaseRepository purchaseDao;
	
	@Override
	public Purchase createPurchase(Purchase purchase) {
		Purchase createdPurchase = null;
		if (purchaseDao.findPurchaseByPurchasePk(purchase.getPurchasePk()) == null)
			createdPurchase = purchaseDao.save(purchase);
		return createdPurchase;
	}

	/*
	@Override
	public Purchase updatePurchase(Purchase purchase) {
		Purchase createdPurchase;
		if (purchaseDao.findPurchaseByPurchasePk(purchase.getPurchasePk()) == null)
			createdPurchase = purchaseDao.save(purchase);
		else
			createdPurchase = null;
		return createdPurchase;
	}
	*/
	
	@Override
	public List<Product> readPurchases(UserEntity user) {
		List<Product> purchasedProducts;
		purchasedProducts = purchaseDao.findPurchasedProductsByUserId(user.getId());
		return purchasedProducts;
	}

}
