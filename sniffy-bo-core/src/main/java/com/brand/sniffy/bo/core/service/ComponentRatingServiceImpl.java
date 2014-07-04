package com.brand.sniffy.bo.core.service;

import java.util.Date;
import java.util.List;

import com.brand.sniffy.bo.core.model.ComponentRating;
import com.brand.sniffy.bo.core.repository.ComponentRatingRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class ComponentRatingServiceImpl implements ComponentRatingService {

	@Autowired
	private ComponentRatingRepository componentRatingRepository;
	
	@Override
	public void saveComponentRating(ComponentRating componentRating) {
		if(componentRating.getId() == null){
			componentRating.setCreationTime(new Date().getTime());
	        componentRating.setDeleted(false);
		}
		componentRating.setLastUpdate(new Date().getTime());
		componentRating.setDeleted(false);
		componentRatingRepository.save(componentRating);
	}

	@Override
	public ComponentRating updateComponentRating(ComponentRating componentRating) {
		componentRating.setLastUpdate(new Date().getTime());
		componentRating.setDeleted(false);
		return componentRatingRepository.save(componentRating);
	}

	@Override
	public List<ComponentRating> findComponentsFromTimeRange(
			Long from, Long to) {
		return componentRatingRepository.findByLastUpdateBetweenAndDeleted(from, to, false);
	}
	
	@Override
	public List<ComponentRating> findComponentsToDeleteFromTimeRange(
			Long from, Long to) {
		return componentRatingRepository.findByLastUpdateBetweenAndDeletedAndCreationTimeLessThan(from, to, true, from);
	}
	
	@Override
    public long countAllComponentRatings() {
        return componentRatingRepository.countByDeleted(false);
    }
    
	@Override
    public void deleteComponentRating(ComponentRating componentRating) {
        componentRating.setDeleted(true);
        componentRating.setLastUpdate(new Date().getTime());
        componentRatingRepository.save(componentRating);
    }
    
	@Override
    public ComponentRating findComponentRating(Long id) {
        return componentRatingRepository.findOne(id);
    }
    
	@Override
    public List<ComponentRating> findAllComponentRatings() {
        return componentRatingRepository.findByDeleted(false);
    }
    
	@Override
    public List<ComponentRating> findComponentRatingEntries(int firstResult, int maxResults) {
        return componentRatingRepository.findByDeleted(false, new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }
    
}
