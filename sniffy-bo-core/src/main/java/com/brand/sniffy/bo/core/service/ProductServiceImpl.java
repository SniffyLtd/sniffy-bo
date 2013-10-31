package com.brand.sniffy.bo.core.service;

import java.util.Date;
import java.util.List;

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

	@Override
	public Product findByBarcode(String barcode) {
		return productRepository.findByBarcode(barcode);
	}

	@Override
	public Product findByName(String name) {
		Product product = productRepository.findByName(name);
		if(product == null){
			List<Product> results = productRepository.findByEquivalentNamesLike(name);
			if(results.size() >0){
				product = results.get(0);
			}
		}
		return product;
	}


	
}
