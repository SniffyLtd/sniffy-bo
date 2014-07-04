package com.brand.sniffy.bo.mobile.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.json.RooJson;

import com.brand.sniffy.bo.core.model.Device;
import com.brand.sniffy.bo.core.model.Product;
import com.brand.sniffy.bo.core.model.SearchRequest;
import com.brand.sniffy.bo.core.model.User;

@RooJavaBean
@RooJson(deepSerialize=true)
public class SynchronizationRequest {

	private Long lastSynchronizationDate;
	
	List<SearchRequest> searchRequests = new ArrayList<SearchRequest>();
	
	List<Product> userDefinedProducts = new ArrayList<Product>();
	
	private Device device;
	
	private User user;
}
