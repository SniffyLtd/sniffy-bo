package com.brand.sniffy.bo.core.service;

import java.util.Date;
import java.util.List;

import com.brand.sniffy.bo.core.model.Component;
import com.brand.sniffy.bo.core.repository.ComponentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class ComponentServiceImpl implements ComponentService {

	@Autowired
	private ComponentRepository componentRepository;
	
	@Override
	public Component saveComponent(Component component) {
		if(component.getId() == null){
			component.setCreationTime(new Date().getTime());
			component.setDeleted(false);
		}
		if(component.getTmp() == null){
			component.setTmp(false);
		}
		component.setLastUpdate(new Date().getTime());
		component.setDeleted(false);
		return componentRepository.save(component);
	}

	@Override
	public Component updateComponent(Component component) {
		component.setLastUpdate(new Date().getTime());
		component.setDeleted(false);
		return componentRepository.save(component);
	}

	@Override
	public Component findByName(String token) {
		Component component = componentRepository.findByNameAndDeleted(token, false);
		if(component != null){
			List<Component> result = componentRepository.findByEquivalentNamesLikeAndDeleted(token, false);
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
		return saveComponent(component);
	}

	@Override
	public List<Component> findAll() {
		return componentRepository.findByDeletedAndTmp(false, false);
	}

	@Override
	public List<Component> findComponentsFromTimeRange(Long from, Long to) {
		return componentRepository.findByLastUpdateBetweenAndDeletedAndTmp(from, to, false, false);
	}

	@Override
	public List<Component> findComponentsToDeleteFromTimeRange(Long from, Long to) {
		return componentRepository.findByLastUpdateBetweenAndDeletedAndCreationTimeLessThanAndTmp(from, to, true, from, false);
	}

	
    @Override
    public long countAllComponents() {
        return componentRepository.countByDeletedAndTmp(false, false);
    }

    @Override
    public void deleteComponent(Component component) {
    	component.setDeleted(true);
    	component.setLastUpdate(new Date().getTime());
		componentRepository.save(component);
    }

    @Override
    public Component findComponent(Long id) {
        return componentRepository.findOne(id);
    }
    
    @Override
    public long countTemporaryComponents() {
        return componentRepository.countByDeletedAndTmp(false, true);
    }
    
    @Override
    public List<Component> findTemporaryComponents(int firstResult, int maxResults) {
    	return componentRepository.findByDeletedAndTmp(false,true, new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

    @Override
    public List<Component> findAllComponents() {
        return componentRepository.findByDeletedAndTmp(false, false);
    }
    
    @Override
    public List<Component> findComponentEntries(int firstResult, int maxResults) {
        return componentRepository.findByDeletedAndTmp(false,false, new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }
}
