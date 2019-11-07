package com.cognizant.truyum.controller;


import javax.validation.Valid;


import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.cognizant.truyum.exception.UserAlreadyExistsException;
import com.cognizant.truyum.model.User;
import com.cognizant.truyum.service.UserDetailsService;
@RestController
@RequestMapping("/users") 
public class UserController{
	@Autowired
	private UserDetailsService userDetailService;
	@Autowired
	private InMemoryUserDetailsManager inUserDetails;
	@PostMapping
	public boolean signUp(@RequestBody @Valid User user) throws UserAlreadyExistsException{
		
		User user1=new User();
		user1.setUsername(user.getUsername());
		String password=passwordEncoder()
	            .encode(user.getPassword());
		user1.setPassword(password);
		
		return userDetailService.signUp(user1);
//		if(inUserDetails.userExists(user.getUsername())){
//			return false;
//		}else{
//			System.out.println("Create User");
//			inUserDetails.createUser(org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
//		            .password(passwordEncoder()
//		    	            .encode(user.getPassword()))
//		    	            .roles("USER").build());
//			return true;
//		}
	}
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
