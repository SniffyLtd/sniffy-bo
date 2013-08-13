package com.brand.application.bo.core.repository;

import com.brand.application.bo.core.model.Product;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Product.class)
public interface ProductRepository {
}
