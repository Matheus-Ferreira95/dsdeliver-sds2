package com.matheusf.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matheusf.dsdeliver.dto.OrderDTO;
import com.matheusf.dsdeliver.entities.Order;
import com.matheusf.dsdeliver.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> list = orderRepository.findOrdersWithProducts();
		return list.stream().map(order -> new OrderDTO(order)).collect(Collectors.toList());
	}	
}
