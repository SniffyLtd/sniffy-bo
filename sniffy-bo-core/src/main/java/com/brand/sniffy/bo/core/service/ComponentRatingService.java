package com.brand.sniffy.bo.core.service;
import java.util.List;

import org.springframework.roo.addon.layers.service.RooService;

import com.brand.sniffy.bo.core.model.ComponentRating;

@RooService(domainTypes = { com.brand.sniffy.bo.core.model.ComponentRating.class })
public interface ComponentRatingService {
	
	public void saveComponentRating(ComponentRating componentRating);
	
	public ComponentRating updateComponentRating(ComponentRating componentRating);

	public List<ComponentRating> findComponentsFromTimeRange(
			Long from, Long to);

	long countAllComponentRatings();

	void deleteComponentRating(ComponentRating componentRating);

	ComponentRating findComponentRating(Long id);

	List<ComponentRating> findAllComponentRatings();

	List<ComponentRating> findComponentRatingEntries(int firstResult,
			int maxResults);

	List<ComponentRating> findComponentsToDeleteFromTimeRange(Long from, Long to);
}
