package com.brand.sniffy.bo.mobile.domain;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.json.RooJson;

import com.brand.sniffy.bo.core.model.Component;
import com.brand.sniffy.bo.core.model.ComponentRating;
import com.brand.sniffy.bo.core.model.Product;


@RooJson(deepSerialize=false)
@RooJavaBean
public class SynchronizationResult {

	private static final String SYNCHRONIZATION_DATE_JSON_FIELD = "synchronizationDate";
	
	private static final String SEARCH_RESULTS_JSON_FIELD = "searchResults";

	private static final String COMPONENTS_TO_UPDATE_JSON_FIELD = "componentsToUpdate";

	private static final String COMPONENT_RATINGS_TO_UPDATE_JSON_FIELD = "componentRatingsToUpdate";

	private static final String PRODUCTS_TO_UPDATE_JSON_FIELD = "productsToUpdate";

	private static final String OTHER_DEVICES_SEARCH_RESULTS_JSON_FIELD = "otherDeviceSearchResults";

	private static final String COMPONENT_RATINGS_TO_DELETE_JSON_FIELD = "componentRatingsToDelete";

	private static final String COMPONENTS_TO_DELETE_JSON_FIELD = "componentsToDelete";

	private static final String PRODUCTS_TO_DELETE_JSON_FIELD = "productsToDelete";;
	
	private Long synchronizationDate;
	
	private List<SearchResult> searchResults = new ArrayList<SearchResult>();
	
	private List<Component> componentsToUpdate = new ArrayList<Component>();
	
	private List<Component> componentsToDelete = new ArrayList<Component>();
	
	private List<ComponentRating> componentRatingsToUpdate = new ArrayList<ComponentRating>();

	private List<ComponentRating> componentRatingsToDelete = new ArrayList<ComponentRating>();
	
	private List<Product> productsToUpdate = new ArrayList<Product>();
	
	private List<Product> productsToDelete = new ArrayList<Product>();
	
	private List<SearchResult> otherDeviceSearchResults = new ArrayList<SearchResult>();
	
	public JSONObject toJson() throws JSONException{
		JSONObject json = new JSONObject();
		json.put(SYNCHRONIZATION_DATE_JSON_FIELD, synchronizationDate);
		JSONArray serachResultsJson = new JSONArray();
		for(SearchResult searchResult : searchResults){
			serachResultsJson.put(searchResult.toJson());
		}
		json.put(SEARCH_RESULTS_JSON_FIELD, serachResultsJson);
		
		JSONArray componentsToUpdateJson = new JSONArray();
		for(Component component : componentsToUpdate){
			componentsToUpdateJson.put(component.toJson());
		}
		json.put(COMPONENTS_TO_UPDATE_JSON_FIELD, componentsToUpdateJson);
		
		JSONArray componentRatingsToUpdateJson = new JSONArray();
		for(ComponentRating rating : componentRatingsToUpdate){
			componentRatingsToUpdateJson.put(rating.toJson());
		}
		json.put(COMPONENT_RATINGS_TO_UPDATE_JSON_FIELD, componentRatingsToUpdateJson);
		
		JSONArray productsToUpdateJson = new JSONArray();
		for(Product product : productsToUpdate){
			productsToUpdateJson.put(product.toJson());
		}
		json.put(PRODUCTS_TO_UPDATE_JSON_FIELD, productsToUpdateJson);
		
		JSONArray otherDevicesSearchResultsJson = new JSONArray();
		for(SearchResult searchResult : otherDeviceSearchResults){
			otherDevicesSearchResultsJson.put(searchResult);
		}
		json.put(OTHER_DEVICES_SEARCH_RESULTS_JSON_FIELD, otherDevicesSearchResultsJson);
		
		JSONArray componentRatingsToDeleteJson = new JSONArray();
		for(ComponentRating rating : componentRatingsToDelete){
			JSONObject ratingJson = new JSONObject();
			ratingJson.put("id", rating.getId());
			componentRatingsToDeleteJson.put(ratingJson);
		}
		json.put(COMPONENT_RATINGS_TO_DELETE_JSON_FIELD, componentRatingsToDeleteJson);

		JSONArray componentsToDeleteJson = new JSONArray();
		for(Component component : componentsToDelete){
			JSONObject componentJson = new JSONObject();
			componentJson.put("id", component.getId());
			componentsToDeleteJson.put(componentJson);
		}
		json.put(COMPONENTS_TO_DELETE_JSON_FIELD, componentsToDeleteJson);
		
		
		JSONArray productsToDeleteJson = new JSONArray();
		for(Product product : productsToDelete){
			JSONObject productJson = new JSONObject();
			productJson.put("id", product.getId());
			productsToDeleteJson.put(productJson);
		}
		json.put(PRODUCTS_TO_DELETE_JSON_FIELD, componentsToDeleteJson);
		return json;
	}
}
