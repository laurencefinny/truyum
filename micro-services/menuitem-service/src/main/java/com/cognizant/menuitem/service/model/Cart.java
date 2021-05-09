	package com.cognizant.menuitem.service.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;


public class Cart {

		private List<MenuItem> menuItemList=new ArrayList<MenuItem>();
		private double total;

		public List<MenuItem> getMenuItemList() {
			return menuItemList;
		}

		public void setMenuItemList(List<MenuItem> menuItemList) {
			this.menuItemList = menuItemList;
		}

	

		public double getTotal() {
			return total;
		}

		public void setTotal(double total) {
			this.total = total;
		}

		public Cart(List<MenuItem> menuItemList, double total2) {
			this.menuItemList = menuItemList;
			this.total = total2;
		}

	}


