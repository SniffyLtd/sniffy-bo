// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.brand.sniffy.bo.core.model;

import com.brand.sniffy.bo.core.model.Component;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect Component_Roo_Jpa_Entity {
    
    declare @type: Component: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Component.id;
    
    @Version
    @Column(name = "version")
    private Integer Component.version;
    
    public Long Component.getId() {
        return this.id;
    }
    
    public void Component.setId(Long id) {
        this.id = id;
    }
    
    public Integer Component.getVersion() {
        return this.version;
    }
    
    public void Component.setVersion(Integer version) {
        this.version = version;
    }
    
}
