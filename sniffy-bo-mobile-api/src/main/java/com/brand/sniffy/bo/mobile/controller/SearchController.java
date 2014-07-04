package com.brand.sniffy.bo.mobile.controller;

import java.util.logging.Logger;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brand.sniffy.bo.core.model.SearchRequest;
import com.brand.sniffy.bo.core.utils.SearchRequestStatus;
import com.brand.sniffy.bo.mobile.domain.ClientContext;
import com.brand.sniffy.bo.mobile.domain.SearchResult;
import com.brand.sniffy.bo.mobile.domain.SynchronizationRequest;
import com.brand.sniffy.bo.mobile.service.SearchService;

@RequestMapping("/search")
@Controller
public class SearchController {
	
	Logger LOG = Logger.getLogger(SearchController.class.getName());
	
	@Autowired
	private SearchService searchService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String>  search(@RequestBody String request, ClientContext clientContext) throws JSONException{
		SearchRequest searchRequest = SearchRequest.fromJsonToSearchRequest(request);
		searchRequest.setOwner(clientContext.getUser());
		searchRequest.setDevice(clientContext.getDevice());
		
		LOG.info(String.format("User '%s' looking for '%s'", clientContext.getUser().getLogin(), searchRequest.getBarcode()));
		SearchResult searchResult = searchService.resolveRequest(searchRequest);
		if(SearchRequestStatus.REJECTED.equals(searchRequest.getStatus())){
			JSONObject json = new JSONObject();
			json.put("message", "Product is on the black list.");
			return new ResponseEntity<String>(json.toString(), responseHeaders(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(searchResult.toJson().toString(), responseHeaders(), HttpStatus.OK);
	}
	
	private HttpHeaders responseHeaders(){
		HttpHeaders heders = new HttpHeaders();
		heders.set("Content-Type", "application/json;charset=UTF-8");
		return heders;
	}
}
