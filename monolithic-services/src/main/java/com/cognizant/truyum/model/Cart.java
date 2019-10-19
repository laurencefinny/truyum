package com.cognizant.truyum.model;

import java.util.ArrayList;

public class Cart {

	private ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
	private double total;

	public ArrayList<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(ArrayList<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cart(ArrayList<MenuItem> menuItemList, double total) {
		this.menuItemList = menuItemList;
		this.total = total;
	}

}
