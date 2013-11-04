package com.brand.sniffy.bo.core.service;

import java.util.Date;
import java.util.List;

import com.brand.sniffy.bo.core.model.Category;
import com.brand.sniffy.bo.core.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void saveCategory(Category category) {
		category.setLastUpdate(new Date().getTime());
		categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		category.setLastUpdate(new Date().getTime());
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> findCategorysChangedAfter(Long lastSynchronization) {
		return categoryRepository.findByLastUpdateGreaterThan(lastSynchronization);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
}
