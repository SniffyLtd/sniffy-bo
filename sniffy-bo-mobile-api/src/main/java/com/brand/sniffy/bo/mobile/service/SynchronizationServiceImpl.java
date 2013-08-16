package com.brand.sniffy.bo.mobile.service;

import java.util.List;
import org.springframework.stereotype.Service;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;

import com.brand.sniffy.bo.core.model.ComponentRating;
import com.brand.sniffy.bo.core.service.CategoryService;
import com.brand.sniffy.bo.core.service.ComponentRatingService;
import com.brand.sniffy.bo.core.service.ComponentService;
import com.brand.sniffy.bo.core.service.CountryService;


@Service
public class SynchronizationServiceImpl implements SynchronizationService{

	private static final String COMPONENT_RATINGS_FIELD = "componentRatings";

	@Autowired
	private ComponentService componentService;
	
	@Autowired
	private ComponentRatingService componentRatingService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private CategoryService categoryService;
	
	public JSONObject initialSynchronization() throws JSONException {
		JSONObject result = new JSONObject();
		JSONArray ratingsJson = new JSONArray();
		List<ComponentRating> ratings = componentRatingService.findAllComponentRatings();
		for(ComponentRating rating : ratings){
			ratingsJson.put(rating.toJson());
		}
		result.put(COMPONENT_RATINGS_FIELD, ratingsJson);
		
		return result;
	}
}
