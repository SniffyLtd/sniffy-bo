// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.brand.sniffy.bo.core.service;

import com.brand.sniffy.bo.core.model.Component;
import com.brand.sniffy.bo.core.service.ComponentService;
import java.util.List;

privileged aspect ComponentService_Roo_Service {
    
    public abstract long ComponentService.countAllComponents();    
    public abstract void ComponentService.deleteComponent(Component component);    
    public abstract Component ComponentService.findComponent(Long id);    
    public abstract List<Component> ComponentService.findAllComponents();    
    public abstract List<Component> ComponentService.findComponentEntries(int firstResult, int maxResults);    
}
