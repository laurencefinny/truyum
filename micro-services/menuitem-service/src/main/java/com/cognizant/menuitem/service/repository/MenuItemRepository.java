package com.cognizant.menuitem.service.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.menuitem.service.model.MenuItem;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, String> {

	@Query(value = "select * from menu_item where me_active=1 and me_date_of_launch<CURRENT_DATE()", nativeQuery = true)
	public List<MenuItem> getAllCustomerList();

	@Query(value = "select * from menu_item where me_id=?1", nativeQuery = true)
	public MenuItem getListByid(@Param("id") int id);

	@Query(value = "select * from menu_item where me_id in(select ct_pr_id from cart where ct_us_id=(select us_id from user where us_name= :name))", nativeQuery = true)
	public List<MenuItem> getMenuItems(@Param(value = "name") String name);

}
