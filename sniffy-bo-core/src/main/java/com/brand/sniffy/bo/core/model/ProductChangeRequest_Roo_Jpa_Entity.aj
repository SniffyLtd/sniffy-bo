// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.brand.sniffy.bo.core.model;

import com.brand.sniffy.bo.core.model.ProductChangeRequest;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect ProductChangeRequest_Roo_Jpa_Entity {
    
    declare @type: ProductChangeRequest: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long ProductChangeRequest.id;
    
    @Version
    @Column(name = "version")
    private Integer ProductChangeRequest.version;
    
    public Long ProductChangeRequest.getId() {
        return this.id;
    }
    
    public void ProductChangeRequest.setId(Long id) {
        this.id = id;
    }
    
    public Integer ProductChangeRequest.getVersion() {
        return this.version;
    }
    
    public void ProductChangeRequest.setVersion(Integer version) {
        this.version = version;
    }
    
}