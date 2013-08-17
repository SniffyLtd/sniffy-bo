package com.brand.sniffy.bo.mobile.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;

import com.brand.sniffy.bo.mobile.service.SynchronizationService;

@RequestMapping("/sync")
@Controller
public class SynchronizationController {
	
	private static final String SYNCHRONIZATION_TIME_FIELD = "synchronizationTime";
	
	private static final String RESULT_FIELD = "result";

	private static final String REASON_FIELD = "reason";
	
	@Autowired
	private SynchronizationService synchronizationService;

	@RequestMapping(method=RequestMethod.GET, value= "/init",
		    headers = {"content-type=application/json"})
	public ResponseEntity<String> initialSynchronization() throws JSONException{

		try{
			JSONObject response = new JSONObject();
			response.put(SYNCHRONIZATION_TIME_FIELD, new Date().getTime());
			JSONObject result = synchronizationService.initialSynchronization();
			response.put(RESULT_FIELD, result);
			return new ResponseEntity<String>(response.toString(), responseHeaders(), HttpStatus.OK);
		}
		catch(JSONException e){
			JSONObject response = new JSONObject();
			response.put(REASON_FIELD, e.getMessage());
			return new ResponseEntity<String>(response.toString(), responseHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value="/{lastSynchronizationDate}",
		    headers = {"content-type=application/json"})
	public @ResponseBody String  synchronization(@PathVariable Long lastSynchronizationDate){
		return "success";
	}
	
	private HttpHeaders responseHeaders(){
		HttpHeaders heders = new HttpHeaders();
		heders.set("Content-Type", "application/json;charset=UTF-8");
		return heders;
	}
}
