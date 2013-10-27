package com.brand.sniffy.bo.core.service;

import java.util.Date;

import com.brand.sniffy.bo.core.model.Product;
import com.brand.sniffy.bo.core.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public void saveProduct(Product product) {
		product.setLastUpdate(new Date().getTime());
		productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		product.setLastUpdate(new Date().getTime());
		return productRepository.save(product);
	}
}
