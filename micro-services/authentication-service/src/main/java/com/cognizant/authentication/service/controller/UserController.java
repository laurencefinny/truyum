package com.cognizant.authentication.service.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.authentication.service.exceptions.UserAlreadyExistsException;

import com.cognizant.authentication.service.model.User;
import com.cognizant.authentication.service.service.UserDetailsService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserDetailsService userDetailService;

	@PostMapping
	public boolean signUp(@RequestBody @Valid User user) throws UserAlreadyExistsException {

		User user1 = new User();
		user1.setUsername(user.getUsername());
		String password = passwordEncoder().encode(user.getPassword());
		user1.setPassword(password);
		System.out.println("User Controller");
		return userDetailService.signUp(user1);

	}

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
