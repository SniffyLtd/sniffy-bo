package com.brand.sniffy.bo.core.service;

import java.util.Date;

import com.brand.sniffy.bo.core.model.ComponentRating;
import com.brand.sniffy.bo.core.repository.ComponentRatingRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class ComponentRatingServiceImpl implements ComponentRatingService {

	@Autowired
	private ComponentRatingRepository componentRatingRepository;
	
	@Override
	public void saveComponentRating(ComponentRating componentRating) {
		componentRating.setLastUpdate(new Date().getTime());
		componentRatingRepository.save(componentRating);
	}

	@Override
	public ComponentRating updateComponentRating(ComponentRating componentRating) {
		componentRating.setLastUpdate(new Date().getTime());
		return componentRatingRepository.save(componentRating);
	}
}
