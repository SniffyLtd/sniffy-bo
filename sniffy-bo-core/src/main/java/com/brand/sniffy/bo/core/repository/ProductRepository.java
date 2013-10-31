package com.brand.sniffy.bo.core.repository;

import java.util.List;

import com.brand.sniffy.bo.core.model.Product;

import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Product.class)
public interface ProductRepository {

	Product findByBarcode(String barcode);

	Product findByName(String name);

	List<Product> findByEquivalentNamesLike(String equivalentNames);
}
