package com.brand.sniffy.bo.mobile.service;

import org.springframework.stereotype.Service;

import org.json.JSONException;
import org.json.JSONObject;


public interface SynchronizationService {
	
	JSONObject initialSynchronization() throws JSONException;

	JSONObject differentialSynchronization(Long lastSynchronizationDate) throws JSONException;
}
