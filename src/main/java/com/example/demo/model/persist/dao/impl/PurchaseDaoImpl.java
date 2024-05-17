package com.example.demo.model.persist.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.entities.Product;
import com.example.demo.model.entities.Purchase;
import com.example.demo.model.entities.UserEntity;
import com.example.demo.model.persist.dao.PurchaseDao;
import com.example.demo.model.persist.repository.PurchaseRepository;

public class PurchaseDaoImpl implements PurchaseDao {
	
	@Autowired
	private PurchaseRepository purchaseDao;
	
	@Override
	public Purchase saveShopping(Purchase purchase) {
		Purchase returnVar;
		if (purchaseDao.findShoppingByUserANDProduct(purchase.getUser().getId(), purchase.getProduct().getProductId()) == null && purchase.getUser() == null && purchase.getProduct() == null)
			returnVar = purchaseDao.save(purchase);
		else
			returnVar = null;
		return returnVar;
	}

	@Override
	public List<Product> listShopping(UserEntity user) {
		List<Product> returnVar;
		returnVar = purchaseDao.findShoppedProductsByUser(user.getId());
		return returnVar;
	}

}
