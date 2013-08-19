package com.brand.sniffy.bo.core.repository;

import java.util.List;

import com.brand.sniffy.bo.core.model.Country;

import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Country.class)
public interface CountryRepository {

	List<Country> findByLastUpdateGreaterThan(Long lastSynchronization);
}
