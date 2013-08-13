package com.brand.application.bo.core.repository;

import com.brand.application.bo.core.model.Category;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Category.class)
public interface CategoryRepository {
}
