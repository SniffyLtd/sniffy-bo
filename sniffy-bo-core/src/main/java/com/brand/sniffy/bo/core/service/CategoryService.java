package com.brand.sniffy.bo.core.service;
import java.util.List;

import org.springframework.roo.addon.layers.service.RooService;

import com.brand.sniffy.bo.core.model.Category;

@RooService(domainTypes = { com.brand.sniffy.bo.core.model.Category.class })
public interface CategoryService {
	
	public void saveCategory(Category category);
	
	public Category updateCategory(Category category);

	public List<Category> findCategorysChangedAfter(Long lastSynchronization);

	public List<Category> findAll();
}
