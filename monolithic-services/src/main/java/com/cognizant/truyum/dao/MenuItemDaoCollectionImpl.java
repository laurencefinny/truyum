package com.cognizant.truyum.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

@Repository

public class MenuItemDaoCollectionImpl implements MenuItemDao {
	// @Autowired
	// @Qualifier("menuItemList")
	private static ArrayList<MenuItem> menuItemList;
	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("truyum.xml");

	public MenuItemDaoCollectionImpl() {

		menuItemList = (ArrayList<MenuItem>) applicationContext.getBean("menuItemList", "ArrayList.class");
	}

	@Override
	public ArrayList<MenuItem> getMenuItemListAdmin() {

		System.out.println("admin collection");
		return menuItemList;
	}

	@Override
	public ArrayList<MenuItem> getMenuItemListCustomer() throws ParseException {

		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String strdate = dateFormat.format(date);
		Date d = DateUtil.convertToDate(strdate);
		ArrayList<MenuItem> menuList = new ArrayList<MenuItem>();
		for (MenuItem menuItem : menuItemList) {
			if ((menuItem.getDateOfLaunch().equals(d) || menuItem.getDateOfLaunch().before(d)) && menuItem.isActive()) {
				menuList.add(menuItem);
			}
		}
		return menuList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {

		int i = 0;
		for (MenuItem menu : menuItemList) {
			if (menu.getId() == menuItem.getId()) {
				break;
			}
			i++;
		}
		menuItemList.set(i, menuItem);
		for (MenuItem menu : menuItemList) {
			System.out.println(menu);
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {

		int flag = 0;
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getId() == menuItemId) {
				return menuItem;
			}
		}
		return null;

	}

}
