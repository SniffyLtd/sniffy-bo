// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.brand.sniffy.bo.core.model;

import com.brand.sniffy.bo.core.model.Component;
import com.brand.sniffy.bo.core.model.Producer;
import com.brand.sniffy.bo.core.model.Product;
import com.brand.sniffy.bo.core.model.ProductChangeRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

privileged aspect ProductChangeRequest_Roo_JavaBean {
    
    public Product ProductChangeRequest.getProduct() {
        return this.product;
    }
    
    public void ProductChangeRequest.setProduct(Product product) {
        this.product = product;
    }
    
    public String ProductChangeRequest.getName() {
        return this.name;
    }
    
    public void ProductChangeRequest.setName(String name) {
        this.name = name;
    }
    
    public String ProductChangeRequest.getSource() {
        return this.source;
    }
    
    public void ProductChangeRequest.setSource(String source) {
        this.source = source;
    }
    
    public BigDecimal ProductChangeRequest.getPrice() {
        return this.price;
    }
    
    public void ProductChangeRequest.setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public Date ProductChangeRequest.getRequestDate() {
        return this.requestDate;
    }
    
    public void ProductChangeRequest.setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }
    
    public String ProductChangeRequest.getDescription() {
        return this.description;
    }
    
    public void ProductChangeRequest.setDescription(String description) {
        this.description = description;
    }
    
    public Set<Component> ProductChangeRequest.getComponents() {
        return this.components;
    }
    
    public void ProductChangeRequest.setComponents(Set<Component> components) {
        this.components = components;
    }
    
    public Producer ProductChangeRequest.getProducer() {
        return this.producer;
    }
    
    public void ProductChangeRequest.setProducer(Producer producer) {
        this.producer = producer;
    }
    
    public String ProductChangeRequest.getBarcode() {
        return this.barcode;
    }
    
    public void ProductChangeRequest.setBarcode(String barcode) {
        this.barcode = barcode;
    }
    
}
