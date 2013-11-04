package com.brand.sniffy.bo.core.repository;
import java.util.List;

import com.brand.sniffy.bo.core.model.ProductChangeRequest;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = ProductChangeRequest.class)
public interface ProductChangeRequestRepository {

	ProductChangeRequest findByBarcodeAndSource(String barcode, String source);

	ProductChangeRequest findByNameAndSource(String name, String source);
	
}
