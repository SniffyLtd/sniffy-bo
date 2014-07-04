package com.brand.sniffy.bo.core.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.brand.sniffy.bo.core.model.SearchRequest;
import com.brand.sniffy.bo.core.repository.SearchRequestRepository;
import com.brand.sniffy.bo.core.utils.SearchRequestStatus;

public class SearchRequestServiceImpl implements SearchRequestService {

	@Autowired
	private SearchRequestRepository searchRequestRepository;
	
	@Override
	public SearchRequest registerRequest(SearchRequest request) {
		request.setProcessingTime(new Date().getTime());
		request.setStatus(SearchRequestStatus.TO_RESOLVE);
		return searchRequestRepository.save(request);
	}

	@Override
	public SearchRequest save(SearchRequest request) {
		return searchRequestRepository.save(request);
	}
	
}
