package com.cognizant.truyum.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.Role;
import com.cognizant.truyum.model.User;
import com.cognizant.truyum.repository.RoleRepository;
import com.cognizant.truyum.repository.UserRepository;

@Service
public class UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	public boolean signUp(User user){
		User dataBaseUser=userRepository.findByUsername(user.getUsername());
		if(dataBaseUser==null){
		Role role=roleRepository.findById(1);
	//	user.getUserroleList().add(role);
		Set<Role> roleList = new HashSet<>();
		roleList.add(role);
			user.setUserroleList(roleList);
			userRepository.save(user);
			return true;
		}else{
			return false;
		}
	}
}
