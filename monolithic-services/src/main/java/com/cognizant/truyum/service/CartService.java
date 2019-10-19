package com.cognizant.truyum.service;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.Cart;

@Service
public class CartService {
	@Autowired
	CartDaoCollectionImpl cartDao;

	public void addCartItem(String id, long menuItemId) throws ParseException {
		cartDao.addCartItem(id, menuItemId);
	}

	public Cart getAllCartItems(String userId) throws NullPointerException, CartEmptyException {
		return cartDao.getAllCartItems(userId);
	}

	public void deleteCartItem(String userId, long menuItemId) {
		cartDao.removeCartItem(userId, menuItemId);
	}
}
