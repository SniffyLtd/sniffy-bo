package com.brand.sniffy.bo.core.repository;

import com.brand.sniffy.bo.core.model.Producer;

import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Producer.class)
public interface ProducerRepository {
}
