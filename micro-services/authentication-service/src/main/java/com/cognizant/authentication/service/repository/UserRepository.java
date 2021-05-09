package com.cognizant.authentication.service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.authentication.service.model.User;





@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
    User findByUsername(String username);
    
    @Query(value = "select sum(me_price) from menu_item where me_id in(select ct_pr_id from cart where ct_us_id=(select us_id from user where us_name= :name))", nativeQuery = true)
    public double getCartTotal(@Param(value = "name") String name);

	
}
