package com.cognizant.truyum.service;

import java.text.ParseException;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;

@Service
public class MenuItemService {
		
//		MenuItemDao menuItemDao;
		@Autowired
		MenuItemRepository menuItemRepository;
		@Transactional
		public List<MenuItem> getMenuItemListCustomer() throws ParseException{
			return menuItemRepository.getAllCustomerList();
			//return menuItemDao.getMenuItemListCustomer();
		}
		public List<MenuItem> getMenuItemListAdmin(){
			System.out.println("Admin Service");
			//return menuItemDao.getMenuItemListAdmin();
			return menuItemRepository.findAll();
		}
		public MenuItem getMenuItem(long id){
			System.out.println("Edit Service"+id);
			int id1=(int)id;
			
			//return menuItemDao.getMenuItem(id);
			return menuItemRepository.getListByid(id1);
		}
		public void modifyMenuItem(MenuItem menuItem){
			//menuItemDao.modifyMenuItem(menuItem);
			menuItemRepository.save(menuItem);
		}
}
