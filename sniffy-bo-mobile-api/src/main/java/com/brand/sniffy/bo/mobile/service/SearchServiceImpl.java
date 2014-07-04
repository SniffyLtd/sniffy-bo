package com.brand.sniffy.bo.mobile.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brand.sniffy.bo.core.model.Product;
import com.brand.sniffy.bo.core.model.SearchRequest;
import com.brand.sniffy.bo.core.service.ProductService;
import com.brand.sniffy.bo.core.service.SearchRequestService;
import com.brand.sniffy.bo.core.utils.SearchRequestStatus;
import com.brand.sniffy.bo.mobile.domain.SearchResult;

@Service
public class SearchServiceImpl implements SearchService{

	@Autowired
	private SearchRequestService searchRequestService;
	
	@Autowired
	private ProductService productService;
	
	@Override
	@Transactional
	public SearchResult resolveRequest(SearchRequest request) {
		
		request = searchRequestService.registerRequest(request);
		
		SearchResult result = new SearchResult();
		result.setRequestTime(request.getRequestDate());
		result.setDevice(request.getDevice());
		
		if(StringUtils.isNotBlank(request.getBarcode())){
			result.setBarcode(request.getBarcode());
			result.setProduct(productService.findByBarcode(request.getBarcode()));
		}
		
		if(result.getProduct() == null && StringUtils.isNotBlank(request.getProductName())){
			result.setProductName(request.getProductName());
			result.setProduct(productService.findByName(request.getProductName()));
		}
		
		if(result.getProduct() == null){
			// TODO: check black list when available and set status to rejected if found
			
			request.setStatus(SearchRequestStatus.FAILED);
			searchRequestService.save(request);
		}
		else{
			request.setStatus(SearchRequestStatus.RESOLVED);
			request.setSearchResult(result.getProduct());
			searchRequestService.save(request);
		}
		
		return result;
	}

}
