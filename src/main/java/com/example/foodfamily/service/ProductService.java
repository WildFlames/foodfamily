package com.example.foodfamily.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.foodfamily.entity.Product;
import com.example.foodfamily.exception.ResourceNotFoundException;
import com.example.foodfamily.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	public Page<Product> filter(String locale, Integer filterId, Long id) {

		Page<Product> productList = null;
		if (id == 0) {
			switch (filterId) {
			case 1:
				productList = productRepository.findAllByLocale(locale,
						PageRequest.of(0, 12, Sort.by(Sort.Direction.ASC, "price")));
				break;
			case 2:
				productList = productRepository.findAllByLocale(locale,
						PageRequest.of(0, 12, Sort.by(Sort.Direction.DESC, "price")));
				break;
			default:
				break;
			}	
		} else if(id != null) {
			switch (filterId) {
			case 1:
				productList = productRepository.findAllByCategoryIdAndLocale(id, locale,
						PageRequest.of(0, 12, Sort.by(Sort.Direction.ASC, "price")));
				break;
			case 2:
				productList = productRepository.findAllByCategoryIdAndLocale(id, locale,
						PageRequest.of(0, 12, Sort.by(Sort.Direction.DESC, "price")));
				break;
			default:
				break;
			}
		}
		return productList;
	}

	@Transactional(readOnly = true)
	public Product findProductById(Long id) {
		Product product = productRepository.findOne(id);
		if (product == null) {
			throw new ResourceNotFoundException("Product not found by id: " + id);
		}
		return product;
	}
}
