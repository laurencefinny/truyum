package com.cognizant.menuitem.service.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.menuitem.service.MenuitemServiceApplication;
import com.cognizant.menuitem.service.model.User;
import com.cognizant.menuitem.service.repository.UserRepository;




@Service
public class AppUserDetailsService implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuitemServiceApplication.class);

	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LOGGER.info("Start");
		LOGGER.debug("UserRepository:{}", userRepository);
		User user = userRepository.findByUsername(username);
		LOGGER.debug("User:{}", user);
		
		if (user != null) {
			LOGGER.info("End");
			return new AppUser(user);
		} else {
			throw new UsernameNotFoundException(username);
		}
	}
}
