package com.brand.sniffy.bo.core.repository;

import java.util.List;

import com.brand.sniffy.bo.core.model.Component;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Component.class)
public interface ComponentRepository {

	Component findByNameAndDeleted(String token, Boolean deleted);

	List<Component> findByEquivalentNamesLikeAndDeleted(String token, Boolean deleted);

	Page<Component> findByDeletedAndTmp(boolean deleted,boolean tmp, Pageable pageable);

	List<Component> findByLastUpdateBetweenAndDeletedAndTmp(Long from, Long to,
			boolean b, boolean c);

	List<Component> findByLastUpdateBetweenAndDeletedAndCreationTimeLessThanAndTmp(
			Long from, Long to, boolean b, Long from2, boolean c);
	
	@Query("select count(e) from Component e where e.deleted = ?1 and e.tmp = ?2")
	long countByDeletedAndTmp(boolean b, boolean c);

	List<Component> findByDeletedAndTmp(boolean deleted, boolean tmp);

}
