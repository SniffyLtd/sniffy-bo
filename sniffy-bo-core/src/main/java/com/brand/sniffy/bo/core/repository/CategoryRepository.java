package com.brand.sniffy.bo.core.repository;

import com.brand.sniffy.bo.core.model.Category;

import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Category.class)
public interface CategoryRepository {
}
