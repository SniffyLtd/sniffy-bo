package com.brand.sniffy.bo.core.service;
import java.util.List;

import org.springframework.roo.addon.layers.service.RooService;

import com.brand.sniffy.bo.core.model.Product;
import com.brand.sniffy.bo.core.model.ProductChangeRequest;
import com.brand.sniffy.bo.core.utils.ProductMergeRequest;

@RooService(domainTypes = { com.brand.sniffy.bo.core.model.ProductChangeRequest.class })
public interface ProductChangeRequestService {
	
	ProductChangeRequest findByBarcodeAndSource(String barcode, String source);

	ProductChangeRequest findByNameAndSource(String barcode, String source);

	void saveProductChangeRequest(ProductChangeRequest productChangeRequest);

	List<ProductChangeRequest> findAll();

	ProductChangeRequest findOne(Long id);

	Product applyChangesToProduct(ProductMergeRequest productMergeRequest);

	Product createProduct(ProductChangeRequest productChangeRequest);
}
