package com.brand.sniffy.bo.core.service;

import java.util.Date;
import java.util.List;

import com.brand.sniffy.bo.core.model.ProductChangeRequest;
import com.brand.sniffy.bo.core.repository.ProductChangeRequestRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductChangeRequestServiceImpl implements ProductChangeRequestService {

	@Autowired
	private ProductChangeRequestRepository productChangeRequestRepository;
	
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
}
