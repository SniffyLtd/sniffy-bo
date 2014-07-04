package com.brand.sniffy.bo.core.repository;

import java.util.List;

import com.brand.sniffy.bo.core.model.ComponentRating;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = ComponentRating.class)
public interface ComponentRatingRepository {

	List<ComponentRating> findByDeleted(boolean deleted);

	ComponentRating findOne(Long id);

	@Query("select count(e) from ComponentRating e where e.deleted = ?1")
	long countByDeleted(boolean deleted);

	Page<ComponentRating> findByDeleted(boolean deleted, Pageable pageRequest);

	List<ComponentRating> findByLastUpdateBetweenAndDeleted(Long from, Long to,
			boolean deleted);

	List<ComponentRating> findByLastUpdateBetweenAndDeletedAndCreationTimeLessThan(
			Long from, Long to, boolean b, Long from2);
}
