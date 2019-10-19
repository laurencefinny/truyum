package com.cognizant.truyum.service;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;

import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService {
	@Autowired
	MenuItemDao menuItemDao;

	public ArrayList<MenuItem> getMenuItemListCustomer() throws ParseException {

		return menuItemDao.getMenuItemListCustomer();
	}

	public ArrayList<MenuItem> getMenuItemListAdmin() {
		System.out.println("Admin Service");
		return menuItemDao.getMenuItemListAdmin();
	}

	public MenuItem getMenuItem(long id) {
		System.out.println("Edit Service" + id);
		return menuItemDao.getMenuItem(id);
	}

	public void modifyMenuItem(MenuItem menuItem) {
		menuItemDao.modifyMenuItem(menuItem);
	}
}
