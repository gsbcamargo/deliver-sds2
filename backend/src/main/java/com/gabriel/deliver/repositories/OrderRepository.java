package com.gabriel.deliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gabriel.deliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> { // entity and data type of the primary id
	
	// this object accesses the database
	@Query("SELECT DISTINCT obj FROM Order obj JOIN FETCH obj.products " 
			+ " WHERE obj.status = 0 ORDER BY obj.moment ASC")
	List<Order> findOrdersWithProducts();
	
}
