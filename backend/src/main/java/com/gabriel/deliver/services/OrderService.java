package com.gabriel.deliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabriel.deliver.dto.OrderDTO;
import com.gabriel.deliver.dto.ProductDTO;
import com.gabriel.deliver.entities.Order;
import com.gabriel.deliver.entities.OrderStatus;
import com.gabriel.deliver.entities.Product;
import com.gabriel.deliver.repositories.OrderRepository;
import com.gabriel.deliver.repositories.ProductRepository;

@Service	
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findOrdersWithProducts();	
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	// add new order associated with products
	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), 
				dto.getLongitude(), Instant.now(), OrderStatus.PENDING);
		for (ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		order = repository.save(order);
		return new OrderDTO(order);
	}

}
