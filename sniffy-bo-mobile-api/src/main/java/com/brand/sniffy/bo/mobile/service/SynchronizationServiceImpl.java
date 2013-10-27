package com.brand.sniffy.bo.mobile.service;

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
import com.brand.sniffy.bo.core.service.CategoryService;
import com.brand.sniffy.bo.core.service.ComponentRatingService;
import com.brand.sniffy.bo.core.service.ComponentService;
import com.brand.sniffy.bo.core.service.CountryService;


@Service
public class SynchronizationServiceImpl implements SynchronizationService{

	private static final String COMPONENT_RATINGS_FIELD = "componentRatings";

	private static final String COMPONENTS_FIELD = "components";

	private static final String COUNTRIES_FIELD = "conutries";

	private static final String CATEGORIES_FIELD = "categories";

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
		List<ComponentRating> ratings = componentRatingService.findAllComponentRatings();
		JSONArray ratingsJson = new JSONArray();
		for(ComponentRating rating : ratings){
			ratingsJson.put(rating.toJson());
		}
		result.put(COMPONENT_RATINGS_FIELD, ratingsJson);
		
		List<Component> components = componentService.findAllComponents();
		JSONArray componentsJson = new JSONArray();
		for(Component component : components){
			componentsJson.put(component.toJson());
		}
		result.put(COMPONENTS_FIELD, componentsJson);
		
		List<Country> countries = countryService.findAllCountrys();
		JSONArray countriesJson = new JSONArray();
		for(Country country : countries){
			countriesJson.put(country.toJson());
		}
		result.put(COUNTRIES_FIELD, countriesJson);
		
		List<Category> categories = categoryService.findAllCategorys();
		JSONArray categoriesJson = new JSONArray();
		for(Category category : categories){
			categoriesJson.put(category.toJson());
		}
		result.put(CATEGORIES_FIELD, categoriesJson);
		return result;
	}

	@Override
	public JSONObject differentialSynchronization(
			Long lastSynchronization) throws JSONException {
		JSONObject result = new JSONObject();
		List<ComponentRating> ratings = componentRatingService.findComponentRatingsChangedAfter(lastSynchronization);
		JSONArray ratingsJson = new JSONArray();
		for(ComponentRating rating : ratings){
			ratingsJson.put(rating.toJson());
		}
		result.put(COMPONENT_RATINGS_FIELD, ratingsJson);
		
		List<Component> components = componentService.findComponentsChangedAfter(lastSynchronization);
		JSONArray componentsJson = new JSONArray();
		for(Component component : components){
			componentsJson.put(component.toJson());
		}
		result.put(COMPONENTS_FIELD, componentsJson);
		
		List<Country> countries = countryService.findCountrysChangedAfter(lastSynchronization);
		JSONArray countriesJson = new JSONArray();
		for(Country country : countries){
			countriesJson.put(country.toJson());
		}
		result.put(COUNTRIES_FIELD, countriesJson);
		
		List<Category> categories = categoryService.findCategorysChangedAfter(lastSynchronization);
		JSONArray categoriesJson = new JSONArray();
		for(Category category : categories){
			categoriesJson.put(category.toJson());
		}
		result.put(CATEGORIES_FIELD, categoriesJson);
		return result;
	}
}
