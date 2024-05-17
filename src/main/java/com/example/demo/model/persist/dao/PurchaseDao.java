package com.example.demo.model.persist.dao;

import java.util.List;

import com.example.demo.model.entities.Product;
import com.example.demo.model.entities.Purchase;
import com.example.demo.model.entities.UserEntity;

public interface PurchaseDao {

	public Purchase saveShopping(Purchase purchase);
	
	public List<Product> listShopping(UserEntity user);
	
}
