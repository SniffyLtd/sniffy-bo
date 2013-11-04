package com.brand.sniffy.bo.core.service;

import java.util.Date;
import java.util.List;

import com.brand.sniffy.bo.core.model.Component;
import com.brand.sniffy.bo.core.repository.ComponentRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class ComponentServiceImpl implements ComponentService {

	
	@Autowired
	private ComponentRepository componentRepository;
	
	@Override
	public void saveComponent(Component component) {
		component.setLastUpdate(new Date().getTime());
		componentRepository.save(component);
	}

	@Override
	public Component updateComponent(Component component) {
		component.setLastUpdate(new Date().getTime());
		return componentRepository.save(component);
	}

	@Override
	public List<Component> findComponentsChangedAfter(Long lastSynchronization) {
		return componentRepository.findByLastUpdateGreaterThan(lastSynchronization);
	}

	@Override
	public Component findByName(String token) {
		Component component = componentRepository.findByName(token);
		if(component != null){
			List<Component> result = componentRepository.findByEquivalentNamesLike(token);
			if(result.size() > 0){
				component = result.get(0);
			}
		}
		return component;
	}

	@Override
	public Component createTemporaryComponent(String token) {
		Component component = new Component();
		component.setName(token);
		component.setTmp(true);
		saveComponent(component);
		
		return component;
	}

	@Override
	public List<Component> findAll() {
		return componentRepository.findAll();
	}
}
