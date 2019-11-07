//package com.cognizant.truyum.dao;
//
//import java.math.BigDecimal;
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import org.springframework.stereotype.Repository;
//
//import com.cognizant.truyum.exception.CartEmptyException;
//import com.cognizant.truyum.model.Cart;
//import com.cognizant.truyum.model.MenuItem;
//@Repository
//public class CartDaoCollectionImpl implements CartDao {
//	private static Map<String, Cart> userCarts = new HashMap<String, Cart>();
//	List<MenuItem> menuItemList =new ArrayList<MenuItem>();
//	public CartDaoCollectionImpl() throws ParseException {
//	
//		if (userCarts.isEmpty()) {
//			// HashMap<Long, Cart> userCarts=new HashMap<Long,Cart>();
//			Cart cart = new Cart(menuItemList, null);
//			//userCarts.put(1l, cart);
//		}
//	}
//
//	public void addCartItem(String userName, long menuItemId) throws ParseException {
//		// TODO Auto-generated method stub
//		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
//		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
//		if (userCarts.containsKey(userName)) {
//			Cart cart1 = userCarts.get(userName);
//			menuItemList = cart1.getMenuItemList();
//			menuItemList.add(menuItem);
//			//System.out.println("If Statatement  "+userCarts.get(userName).getMenuItemList().size());
//		} else {
//			Cart cart1 = new Cart(new ArrayList<MenuItem>(), null);
//			menuItemList = cart1.getMenuItemList();
//			menuItemList.add(menuItem);
//				System.out.println("Else Statement");
//				userCarts.put(userName, cart1);
//		
//		}
//		//System.out.println(userCarts.get(userName).getMenuItemList()+"   "+userName+"  "+menuItemId);
//	}
//
//	@Override
//	public Cart getAllCartItems(String userName) throws CartEmptyException, NullPointerException {
//		// TODO Auto-generated method stub
//		Cart cart1 = userCarts.get(userName);
//		System.out.println(cart1);
//		BigDecimal test = new BigDecimal(0);
//		BigDecimal total=null;
//		List<MenuItem> menuItemList = cart1.getMenuItemList();
//		try {
//			if (menuItemList.isEmpty()) {
//				throw new CartEmptyException();
//			} else {
//				for (MenuItem menu : menuItemList) {
//					total=test.add(menu.getPrice());
//				}
//				Cart cart = new Cart(menuItemList, total);
//
//				return cart;
//			}
//		} catch (Exception e) {
//
//		}
//		return null;
//	}
//
//	@Override
//	public void removeCartItem(String userName, long menuItemId) throws NullPointerException {
//		// TODO Auto-generated method stub
//		Cart c = userCarts.get(userName);
//		BigDecimal test = new BigDecimal(0);
//		BigDecimal total=null;
//	menuItemList = c.getMenuItemList();
//		for (MenuItem menuItem : menuItemList) {
//			if (menuItem.getId() == menuItemId) {
//			total=c.getTotal().subtract(menuItem.getPrice());
//				c.setTotal(total);
//				menuItemList.remove(menuItem);
//				break;
//			}
//		}
//	}
//}
