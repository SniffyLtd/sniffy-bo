package com.brand.sniffy.bo.core.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.brand.sniffy.bo.core.model.Component;
import com.brand.sniffy.bo.core.model.Product;
import com.brand.sniffy.bo.core.model.ProductChangeRequest;
import com.brand.sniffy.bo.core.repository.ProductChangeRequestRepository;
import com.brand.sniffy.bo.core.utils.ProductMergeRequest;
import com.brand.sniffy.bo.core.utils.ProductMergeRequest.Type;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductChangeRequestServiceImpl implements ProductChangeRequestService {

	@Autowired
	private ProductChangeRequestRepository productChangeRequestRepository;
	
	@Autowired
	private ProductService productService;
	
	@Override
	public ProductChangeRequest findByBarcodeAndSource(String barcode,
			String source) {
		return productChangeRequestRepository.findByBarcodeAndSource(barcode, source);
	}

	@Override
	public ProductChangeRequest findByNameAndSource(String barcode,
			String source) {
		return productChangeRequestRepository.findByNameAndSource(barcode, source);
	}

	@Override
	public void saveProductChangeRequest(
			ProductChangeRequest productChangeRequest) {
		productChangeRequestRepository.save(productChangeRequest);
	}

	@Override
	public List<ProductChangeRequest> findAll() {
		return productChangeRequestRepository.findAll();
	}

	@Override
	public ProductChangeRequest findOne(Long id) {
		return productChangeRequestRepository.findOne(id);
	}

	@Override
	public Product applyChangesToProduct(ProductMergeRequest productMergeRequest) {
		ProductChangeRequest request = productChangeRequestRepository.findOne(productMergeRequest.getProductChangeRequest());
		Product product = request.getProduct();
		if(productMergeRequest.isName()){
			product.setName(request.getName());
		}
		else if(request.getName() != null){
			String names = product.getEquivalentNames();
			if(names == null || names.isEmpty()){
				names = request.getName();
			}
			else if(!names.contains(request.getName())){
				names += ", " + request.getName();
			}
		}
		if(productMergeRequest.isBarcode()){
			product.setBarcode(request.getBarcode());
		}
		
		if(productMergeRequest.getComponents() == Type.merge){
			Set<Component> components = new HashSet<Component>();
			components.addAll(product.getComponents());
			components.addAll(request.getComponents());
			product.getComponents().clear();
			product.getComponents().addAll(components);
		}else if(productMergeRequest.getComponents() == Type.overwrite){
			Set<Component> components = new HashSet<Component>();
			components.addAll(request.getComponents());
			product.setComponents(components);
		}
		
		if(productMergeRequest.getDescription() == Type.merge){
			product.setDescription((product.getDescription() == null?"":product.getDescription())  + request.getDescription());
		}
		else if (productMergeRequest.getDescription() == Type.overwrite){
			product.setDescription(request.getDescription());
		}
		
		if(productMergeRequest.isCategory()){
			product.setCategory(request.getCategory());
		}
		
		if(productMergeRequest.isProducer()){
			product.setProducer(request.getProducer());
		}
		return product;
	}

	@Override
	public Product createProduct(ProductChangeRequest productChangeRequest) {
		Product product = new Product();
		product.setName(productChangeRequest.getName());
		product.setBarcode(productChangeRequest.getBarcode());
		product.setDescription(productChangeRequest.getDescription());
		product.setComponents(productChangeRequest.getComponents());
		product.setProducer(productChangeRequest.getProducer());
		product.setCategory(productChangeRequest.getCategory());
		return product;
	}
}
