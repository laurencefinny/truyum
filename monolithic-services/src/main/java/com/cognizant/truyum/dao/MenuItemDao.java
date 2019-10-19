package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {
	ArrayList<MenuItem> getMenuItemListAdmin();

	ArrayList<MenuItem> getMenuItemListCustomer() throws ParseException;

	void modifyMenuItem(MenuItem menuItem);

	MenuItem getMenuItem(long menuItemId);

}
