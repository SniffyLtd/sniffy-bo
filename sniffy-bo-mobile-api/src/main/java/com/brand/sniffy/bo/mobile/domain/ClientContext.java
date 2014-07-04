package com.brand.sniffy.bo.mobile.domain;

import org.springframework.roo.addon.javabean.RooJavaBean;

import com.brand.sniffy.bo.core.model.Device;
import com.brand.sniffy.bo.core.model.User;

@RooJavaBean
public class ClientContext {

	public ClientContext(){
	}
	
	public ClientContext(User user, Device device) {
		this.user = user;
		this.device = device;
	}

	private User user;
	
	private Device device;
}
