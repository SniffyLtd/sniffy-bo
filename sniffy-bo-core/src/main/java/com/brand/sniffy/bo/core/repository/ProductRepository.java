package com.brand.sniffy.bo.core.repository;

import java.util.List;

import com.brand.sniffy.bo.core.model.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Product.class)
public interface ProductRepository {

	Product findByName(String name);

	Product findByBarcodeAndDeleted(String barcode, boolean deleted);

	List<Product> findByEquivalentNamesLikeAndDeleted(String name, boolean deleted);

	List<Product> findByDeleted(boolean deleted);

	Page<Product> findByDeleted(boolean deleted, Pageable pageable);

	@Query("select count(e) from Product e where e.deleted = ?1")
	long countByDeleted(boolean b);
}
