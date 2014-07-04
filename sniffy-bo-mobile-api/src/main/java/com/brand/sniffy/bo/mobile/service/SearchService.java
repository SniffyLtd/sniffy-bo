package com.brand.sniffy.bo.mobile.service;

import com.brand.sniffy.bo.core.model.SearchRequest;
import com.brand.sniffy.bo.mobile.domain.SearchResult;

public interface SearchService {

	SearchResult resolveRequest(SearchRequest request);
}
