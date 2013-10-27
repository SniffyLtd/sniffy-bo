package com.brand.sniffy.bo.core.repository;

import java.util.List;

import com.brand.sniffy.bo.core.model.Component;

import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Component.class)
public interface ComponentRepository {

	List<Component> findByLastUpdateGreaterThan(Long lastSynchronization);
}
