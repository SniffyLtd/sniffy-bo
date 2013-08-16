package com.brand.sniffy.bo.core.service;
import org.springframework.roo.addon.layers.service.RooService;

import com.brand.sniffy.bo.core.model.Component;

@RooService(domainTypes = { com.brand.sniffy.bo.core.model.Component.class })
public interface ComponentService {
	
	public void saveComponent(Component component);
	
	public Component updateComponent(Component component);
}
