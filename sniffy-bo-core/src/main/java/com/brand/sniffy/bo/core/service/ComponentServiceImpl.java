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
}
