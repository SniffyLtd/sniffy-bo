package com.brand.sniffy.bo.mobile.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;

import com.brand.sniffy.bo.mobile.domain.ClientContext;
import com.brand.sniffy.bo.mobile.domain.SynchronizationRequest;
import com.brand.sniffy.bo.mobile.domain.SynchronizationResult;
import com.brand.sniffy.bo.mobile.service.SynchronizationService;

@RequestMapping("/sync")
@Controller
public class SynchronizationController {
	
	@Autowired
	private SynchronizationService synchronizationService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String>  synchronize(@RequestBody String request, ClientContext clientContext) throws JSONException{
		SynchronizationRequest syncRequest = SynchronizationRequest.fromJsonToSynchronizationRequest(request);
		syncRequest.setDevice(clientContext.getDevice());
		syncRequest.setUser(clientContext.getUser());
		SynchronizationResult result = synchronizationService.performSynchronization(syncRequest);
		return new ResponseEntity<String>(result.toJson().toString(),
				responseHeaders(), HttpStatus.OK);
	}
	
	private HttpHeaders responseHeaders(){
		HttpHeaders heders = new HttpHeaders();
		heders.set("Content-Type", "application/json;charset=UTF-8");
		return heders;
	}
}
