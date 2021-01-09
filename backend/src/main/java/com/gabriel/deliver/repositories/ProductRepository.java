package com.gabriel.deliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.deliver.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> { // entity and data type of the primary id
	
	// this object accesses the database
	
}
