package com.cognizant.menuitem.service.service;

import java.math.BigDecimal;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.menuitem.service.exception.CartEmptyException;
import com.cognizant.menuitem.service.model.Cart;
import com.cognizant.menuitem.service.model.MenuItem;
import com.cognizant.menuitem.service.model.User;
import com.cognizant.menuitem.service.repository.MenuItemRepository;
import com.cognizant.menuitem.service.repository.UserRepository;

import java.util.*;

import javax.transaction.Transactional;

@Service
public class CartService {
//	@Autowired
//	CartDaoCollectionImpl cartDao;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MenuItemRepository menuItemRepository;
	
	@Transactional
	public void addCartItem(String id,long menuItemId) throws ParseException{
		User user=userRepository.findByUsername(id);
		System.out.println(user.toString());
		int menuid=(int)menuItemId;
		MenuItem menuItem=menuItemRepository.getListByid(menuid);
		System.out.println(menuItem.toString());
		user.getMenuItemList().add(menuItem);
		System.out.println(user.toString());
		//user.setMenuItemList(menuItemList);
		userRepository.save(user);
		System.out.println("Hello");
		//cartDao.addCartItem(id, menuItemId);
	}
	@Transactional
	public Cart getAllCartItems(String userId) throws NullPointerException, CartEmptyException{
		 ArrayList<MenuItem> menuItemList=(ArrayList<MenuItem>) menuItemRepository.getMenuItems(userId);
		 double total =userRepository.getCartTotal(userId);
			if(total==0){
				throw new CartEmptyException();
			}
			else{	 
		 Cart cart=new Cart(menuItemList,total);
		 return cart;
			}
		 
	}
	@Transactional
	public void deleteCartItem(String userId,long menuItemId) throws CartEmptyException{
	//	cartDao.removeCartItem(userId, menuItemId);
			User user=userRepository.findByUsername(userId);
			List<MenuItem> menuItemList=(user.getMenuItemList());
			if(menuItemList==null ){
				throw new CartEmptyException();
			}else{
			int i = 0;
	        for (MenuItem menuitem : menuItemList) {
	             System.out.println("menuitem.getId()............remove cart item"+menuitem.getId());
	                if (menuitem.getId() == menuItemId) {
	                        break;
	                }
	                i++;
	        }
	        menuItemList.remove(i);
	        user.setMenuItemList( menuItemList);
	        userRepository.save(user);
	}
	}
}
