package com.brand.sniffy.bo.mobile.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;

import com.brand.sniffy.bo.core.model.Category;
import com.brand.sniffy.bo.core.model.Component;
import com.brand.sniffy.bo.core.model.ComponentRating;
import com.brand.sniffy.bo.core.model.Country;
import com.brand.sniffy.bo.core.model.Device;
import com.brand.sniffy.bo.core.model.SearchRequest;
import com.brand.sniffy.bo.core.model.User;
import com.brand.sniffy.bo.core.service.CategoryService;
import com.brand.sniffy.bo.core.service.ComponentRatingService;
import com.brand.sniffy.bo.core.service.ComponentService;
import com.brand.sniffy.bo.core.service.CountryService;
import com.brand.sniffy.bo.mobile.domain.SearchResult;
import com.brand.sniffy.bo.mobile.domain.SynchronizationRequest;
import com.brand.sniffy.bo.mobile.domain.SynchronizationResult;


@Service
public class SynchronizationServiceImpl implements SynchronizationService{

	@Autowired
	private ComponentService componentService;
	
	@Autowired
	private ComponentRatingService componentRatingService;
	
	@Autowired
	private SearchService searchService;

	@Override
	public SynchronizationResult performSynchronization(SynchronizationRequest request){
		SynchronizationResult result = new SynchronizationResult();
		Long from = request.getLastSynchronizationDate();
		Long to = new Date().getTime();
		result.setSearchResults(resolveSearchRequests(request.getSearchRequests(), request.getUser(), request.getDevice()));
		result.setComponentRatingsToUpdate(componentRatingService.findComponentsFromTimeRange(from, to));
		result.setComponentRatingsToDelete(componentRatingService.findComponentsToDeleteFromTimeRange(from, to));
		result.setComponentsToUpdate(componentService.findComponentsFromTimeRange(from, to));
		result.setComponentsToDelete(componentService.findComponentsToDeleteFromTimeRange(from, to));
		
		result.setSynchronizationDate(to);
		return result;
	}
	
	private List<SearchResult> resolveSearchRequests(List<SearchRequest> requests, User user, Device device){
		
		List<SearchResult> results = new ArrayList<SearchResult>();
		for(SearchRequest request : requests){
			request.setOwner(user);
			request.setDevice(device);
			
			SearchResult result = searchService.resolveRequest(request);
			if(result != null ){
				results.add(result);
			}
		}
		return results;
	}
}
