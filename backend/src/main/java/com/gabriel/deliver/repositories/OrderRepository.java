package com.gabriel.deliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.deliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> { // entity and data type of the primary id
	
	// this object accesses the database
	
}
