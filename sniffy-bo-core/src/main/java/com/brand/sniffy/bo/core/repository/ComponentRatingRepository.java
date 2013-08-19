package com.brand.sniffy.bo.core.repository;

import java.util.List;

import com.brand.sniffy.bo.core.model.ComponentRating;

import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = ComponentRating.class)
public interface ComponentRatingRepository {

	List<ComponentRating> findByLastUpdateGreaterThan(Long lastSynchronization);
}
