package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Repository
public class CartDaoCollectionImpl implements CartDao {
	private static Map<String, Cart> userCarts = new HashMap<String, Cart>();
	ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();

	public CartDaoCollectionImpl() throws ParseException {

		if (userCarts.isEmpty()) {
			// HashMap<Long, Cart> userCarts=new HashMap<Long,Cart>();
			Cart cart = new Cart(menuItemList, 0);

		}
	}

	public void addCartItem(String userName, long menuItemId) throws ParseException {

		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		if (userCarts.containsKey(userName)) {
			Cart cart1 = userCarts.get(userName);
			menuItemList = cart1.getMenuItemList();
			menuItemList.add(menuItem);
			System.out.println("If Statatement  " + userCarts.get(userName).getMenuItemList().size());
		} else {
			Cart cart1 = new Cart(new ArrayList<MenuItem>(), menuItem.getPrice());
			menuItemList = cart1.getMenuItemList();
			menuItemList.add(menuItem);
			System.out.println("Else Statement");
			userCarts.put(userName, cart1);

		}
	}

	@Override
	public Cart getAllCartItems(String userName) throws CartEmptyException, NullPointerException {

		Cart cart1 = userCarts.get(userName);
		System.out.println(cart1);
		ArrayList<MenuItem> menuItemList = cart1.getMenuItemList();
		try {
			if (menuItemList.isEmpty()) {
				throw new CartEmptyException();
			} else {
				float total = 0;
				for (MenuItem menu : menuItemList) {
					total += menu.getPrice();
				}
				Cart cart = new Cart(menuItemList, total);

				return cart;
			}
		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public void removeCartItem(String userName, long menuItemId) throws NullPointerException {
		Cart c = userCarts.get(userName);
		ArrayList<MenuItem> list = c.getMenuItemList();
		for (MenuItem menuItem : list) {
			if (menuItem.getId() == menuItemId) {
				list.remove(menuItem);
				break;
			}
		}
	}
}
