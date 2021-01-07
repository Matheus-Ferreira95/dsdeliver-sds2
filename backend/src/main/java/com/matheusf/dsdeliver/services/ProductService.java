package com.matheusf.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.matheusf.dsdeliver.dto.ProductDTO;
import com.matheusf.dsdeliver.entities.Product;
import com.matheusf.dsdeliver.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<ProductDTO> findAll() {
		List<Product> list = productRepository.findAllByOrderByNameAsc();
		return list.stream().map(product -> new ProductDTO(product)).collect(Collectors.toList());
	}
	
}
