package com.brand.sniffy.bo.core.repository;
import com.brand.sniffy.bo.core.model.SearchRequest;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = SearchRequest.class)
public interface SearchRequestRepository {
}
