package com.brand.sniffy.bo.core.service;
import org.springframework.roo.addon.layers.service.RooService;

import com.brand.sniffy.bo.core.model.Product;

@RooService(domainTypes = { com.brand.sniffy.bo.core.model.Product.class })
public interface ProductService {
	
	public void saveProduct(Product product);
	
	public Product updateProduct(Product product);
}
