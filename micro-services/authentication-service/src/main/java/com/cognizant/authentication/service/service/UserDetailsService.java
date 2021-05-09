package com.cognizant.authentication.service.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.authentication.service.model.Role;
import com.cognizant.authentication.service.model.User;
import com.cognizant.authentication.service.repository.RoleRepository;
import com.cognizant.authentication.service.repository.UserRepository;

@Service
public class UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Transactional
	public boolean signUp(User user) {
		User dataBaseUser = userRepository.findByUsername(user.getUsername());
		if (dataBaseUser == null) {
			Role role = roleRepository.findById(1);
			// user.getUserroleList().add(role);
			Set<Role> roleList = new HashSet<>();
			roleList.add(role);
			user.setUserroleList(roleList);
			userRepository.save(user);
			return true;
		} else {
			return false;
		}
	}
}
