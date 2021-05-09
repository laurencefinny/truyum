package com.cognizant.authentication.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.authentication.service.model.Role;



public interface RoleRepository extends JpaRepository<Role, String>{
	

		Role findById(int i); 
}
