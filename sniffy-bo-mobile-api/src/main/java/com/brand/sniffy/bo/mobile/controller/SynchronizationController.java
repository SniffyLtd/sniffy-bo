package com.brand.sniffy.bo.mobile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONException;
import org.json.JSONObject;


import com.brand.sniffy.bo.mobile.service.SynchronizationService;

@RequestMapping("/sync")
@Controller
public class SynchronizationController {
	
	private static final String STATUS_FIELD = "status";
	
	private static final String SUCCESS_STATUS = "success";
	
	private static final String RESULT_FIELD = "result";

	private static final String INTERNAL_ERROR = "internalError";

	private static final String REASON_FIELD = "reason";
	
	@Autowired
	private SynchronizationService synchronizationService;

	@RequestMapping(method=RequestMethod.GET, value= "/init")
	public @ResponseBody String initialSynchronization() throws JSONException{

		try{
			JSONObject result = synchronizationService.initialSynchronization();
			JSONObject response = new JSONObject();
			response.put(STATUS_FIELD, SUCCESS_STATUS);
			response.put(RESULT_FIELD, result);
			return response.toString();
		}
		catch(JSONException e){
			JSONObject response = new JSONObject();
			response.put(STATUS_FIELD, INTERNAL_ERROR);
			response.put(REASON_FIELD, e.getMessage());
			return response.toString();
		}
		
	}
	
	@RequestMapping(value="/{lastSynchronizationDate}")
	public @ResponseBody String  synchronization(@PathVariable Long lastSynchronizationDate){
		return "success";
	}
}
