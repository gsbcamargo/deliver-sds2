package com.gabriel.deliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabriel.deliver.dto.ProductDTO;
import com.gabriel.deliver.entities.Product;
import com.gabriel.deliver.repositories.ProductRepository;

@Service	
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {
		List<Product> list = repository.findAll();	
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}

}
