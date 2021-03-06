// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.brand.sniffy.bo.core.model;

import com.brand.sniffy.bo.core.model.Device;
import com.brand.sniffy.bo.core.model.Product;
import com.brand.sniffy.bo.core.model.SearchRequest;
import com.brand.sniffy.bo.core.model.User;
import com.brand.sniffy.bo.core.utils.SearchRequestStatus;
import java.util.Date;

privileged aspect SearchRequest_Roo_JavaBean {
    
    public String SearchRequest.getBarcode() {
        return this.barcode;
    }
    
    public void SearchRequest.setBarcode(String barcode) {
        this.barcode = barcode;
    }
    
    public Date SearchRequest.getRequestDate() {
        return this.requestDate;
    }
    
    public void SearchRequest.setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }
    
    public Long SearchRequest.getProcessingTime() {
        return this.processingTime;
    }
    
    public void SearchRequest.setProcessingTime(Long processingTime) {
        this.processingTime = processingTime;
    }
    
    public String SearchRequest.getProductName() {
        return this.productName;
    }
    
    public void SearchRequest.setProductName(String productName) {
        this.productName = productName;
    }
    
    public User SearchRequest.getOwner() {
        return this.owner;
    }
    
    public void SearchRequest.setOwner(User owner) {
        this.owner = owner;
    }
    
    public Device SearchRequest.getDevice() {
        return this.device;
    }
    
    public void SearchRequest.setDevice(Device device) {
        this.device = device;
    }
    
    public Product SearchRequest.getSearchResult() {
        return this.searchResult;
    }
    
    public void SearchRequest.setSearchResult(Product searchResult) {
        this.searchResult = searchResult;
    }
    
    public SearchRequestStatus SearchRequest.getStatus() {
        return this.status;
    }
    
    public void SearchRequest.setStatus(SearchRequestStatus status) {
        this.status = status;
    }
    
}
