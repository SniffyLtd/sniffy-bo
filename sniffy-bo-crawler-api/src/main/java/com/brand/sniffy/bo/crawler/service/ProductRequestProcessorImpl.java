package com.brand.sniffy.bo.crawler.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.brand.sniffy.bo.core.model.Component;
import com.brand.sniffy.bo.core.model.Product;
import com.brand.sniffy.bo.core.model.ProductChangeRequest;
import com.brand.sniffy.bo.core.service.ComponentService;
import com.brand.sniffy.bo.core.service.ProductChangeRequestService;
import com.brand.sniffy.bo.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import com.brand.sniffy.bo.crawler.request.ProductRequest;

import org.springframework.stereotype.Service;

@Service
public class ProductRequestProcessorImpl implements ProductRequestProcessor {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductChangeRequestService productChangeRequestService;
	
	@Autowired
	private ComponentService componentService;
	
	@Override
	public void processRequest(ProductRequest productRequest) {
		
		productRequest.clearProducerName().clearName().clearPrice();
		
		ProductChangeRequest productChangeRequest = findExistingProductChangeRequest(productRequest);
		
		if(productChangeRequest == null){
			productChangeRequest  = new ProductChangeRequest();
		}
		productChangeRequest.setProduct(matchProduct(productRequest));
		productChangeRequest.setBarcode(productRequest.getBarcode());
		productChangeRequest.setName(productRequest.getName());
		productChangeRequest.setDescription(productRequest.getDescription());
		productChangeRequest.setSource(productRequest.getUrl());
		productChangeRequest.setPrice(new BigDecimal(productRequest.getPrice()));
		productChangeRequest.setComponents(resolveComponents(productRequest.getComponents()));
		productChangeRequest.setRequestDate(new Date());
		
		productChangeRequestService.saveProductChangeRequest(productChangeRequest);
	}

	private ProductChangeRequest findExistingProductChangeRequest(
			ProductRequest productRequest) {
		ProductChangeRequest productChangeRequest = null;
		if(productRequest.getBarcode()!=null && !productRequest.getBarcode().isEmpty()){
			productChangeRequest = productChangeRequestService
					.findByBarcodeAndSource(productRequest.getBarcode(), productRequest.getUrl());
		}
		if(productChangeRequest == null){
			productChangeRequest = productChangeRequestService
					.findByNameAndSource(productRequest.getName(), productRequest.getUrl());
		}
		return productChangeRequest;
	}

	private Product matchProduct(ProductRequest productRequest) {
		Product product = productService.findByBarcode(productRequest.getBarcode());
		if(product == null){
			product = productService.findByName(productRequest.getName());
		}
		
		return product;
	}
	
	private Set<Component> resolveComponents(String data){
		String[] tokens = data.split(",");
		
		Set<Component> components = new HashSet<Component>();
		for(String token: tokens){
			token = token.trim();
			if(token.endsWith(":")){
				continue;
			}
			
			Component component = componentService.findByName(token);
			if(component == null){
				component = componentService.createTemporaryComponent(token);
			}
			components.add(component);
		}
		
		return components;
	}
}
