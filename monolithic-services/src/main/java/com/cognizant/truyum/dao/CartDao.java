package com.cognizant.truyum.dao;

import java.text.ParseException;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.Cart;

public interface CartDao {
	void addCartItem(String userName, long menuItemId) throws ParseException;

	Cart getAllCartItems(String userName) throws CartEmptyException;

	void removeCartItem(String userName, long menuItemId);
}
