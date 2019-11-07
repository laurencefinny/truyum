package com.cognizant.truyum.controller;


import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;
@RestController
@RequestMapping("/carts")
public class CartController {
@Autowired
	CartService cartService;
	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@PathVariable String userId,@PathVariable long menuItemId) throws ParseException{
			cartService.addCartItem(userId, menuItemId);
		
	}
	@GetMapping("/{userId}")
	public Cart getAllCartItems(@PathVariable String userId) throws NullPointerException, CartEmptyException{
		return cartService.getAllCartItems(userId);
	}
	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteCartItem(@PathVariable String userId,@PathVariable String menuItemId) throws CartEmptyException{
		long menuId=Long.parseLong(menuItemId);
		System.out.println(userId+"  "+menuId);
		cartService.deleteCartItem(userId, menuId);
	}
}
