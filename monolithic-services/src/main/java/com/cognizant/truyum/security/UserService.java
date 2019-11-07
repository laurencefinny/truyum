package com.cognizant.truyum.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.User;
import com.cognizant.truyum.repository.UserRepository;



@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Transactional
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
