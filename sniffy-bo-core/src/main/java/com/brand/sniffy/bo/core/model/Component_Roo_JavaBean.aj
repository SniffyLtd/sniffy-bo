// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.brand.sniffy.bo.core.model;

import com.brand.sniffy.bo.core.model.Component;
import com.brand.sniffy.bo.core.model.ComponentRating;

privileged aspect Component_Roo_JavaBean {
    
    public String Component.getName() {
        return this.name;
    }
    
    public void Component.setName(String name) {
        this.name = name;
    }
    
    public String Component.getEquivalentNames() {
        return this.equivalentNames;
    }
    
    public void Component.setEquivalentNames(String equivalentNames) {
        this.equivalentNames = equivalentNames;
    }
    
    public ComponentRating Component.getRating() {
        return this.rating;
    }
    
    public void Component.setRating(ComponentRating rating) {
        this.rating = rating;
    }
    
    public long Component.getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void Component.setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
    public String Component.getDescription() {
        return this.description;
    }
    
    public void Component.setDescription(String description) {
        this.description = description;
    }
    
}
