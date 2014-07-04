package com.brand.sniffy.bo.core.service;
import java.util.List;

import org.springframework.roo.addon.layers.service.RooService;

import com.brand.sniffy.bo.core.model.Component;

@RooService(domainTypes = { com.brand.sniffy.bo.core.model.Component.class })
public interface ComponentService {
	
	public Component saveComponent(Component component);
	
	public Component updateComponent(Component component);

	public List<Component> findComponentsFromTimeRange(Long from, Long to);

	public Component findByName(String token);

	public Component createTemporaryComponent(String token);
	
	public List<Component> findAll();

	long countAllComponents();

	Component findComponent(Long id);

	void deleteComponent(Component component);

	List<Component> findAllComponents();

	List<Component> findComponentEntries(int firstResult, int maxResults);

	List<Component> findComponentsToDeleteFromTimeRange(Long from, Long to);

	long countTemporaryComponents();

	List<Component> findTemporaryComponents(int firstResult, int maxResults);
	

}
