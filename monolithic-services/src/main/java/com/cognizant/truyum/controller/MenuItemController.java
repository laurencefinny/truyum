package com.cognizant.truyum.controller;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {
	@Autowired
	MenuItemService menuItemService;
	@Autowired
	InMemoryUserDetailsManager inMemoryUserDetailsManager;

	@GetMapping
	public ArrayList<MenuItem> getAllMenuItems() throws ParseException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();
		UserDetails userDetails = inMemoryUserDetailsManager.loadUserByUsername(user);
		String role = userDetails.getAuthorities().toArray()[0].toString();
		System.out.println(role);
		if (role.equals("ROLE_ADMIN")) {
			return menuItemService.getMenuItemListAdmin();
		} else if (role.equals("ROLE_USER")) {
			return menuItemService.getMenuItemListCustomer();
		} else {
			return menuItemService.getMenuItemListCustomer();
		}
	}

	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable long id) {
		// System.out.println("Edit Col"+id);
		return menuItemService.getMenuItem(id);

	}

	@PutMapping
	public void modifyMenuItem(@RequestBody MenuItem menuItem) {
		System.out.println("Modify Controller");
		menuItemService.modifyMenuItem(menuItem);
	}
}
