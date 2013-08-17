package com.brand.sniffy.bo.core.repository;

import com.brand.sniffy.bo.core.model.Product;

import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Product.class)
public interface ProductRepository {

	Product findByBarcode(String barcode);
}