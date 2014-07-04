package com.brand.sniffy.bo.core.service;
import org.springframework.roo.addon.layers.service.RooService;

import com.brand.sniffy.bo.core.model.SearchRequest;

@RooService(domainTypes = { com.brand.sniffy.bo.core.model.SearchRequest.class })
public interface SearchRequestService {

	SearchRequest registerRequest(SearchRequest request);

	SearchRequest save(SearchRequest request);
}
