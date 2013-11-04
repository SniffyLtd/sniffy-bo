// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.brand.sniffy.bo.core.service;

import com.brand.sniffy.bo.core.model.ProductChangeRequest;
import com.brand.sniffy.bo.core.service.ProductChangeRequestServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ProductChangeRequestServiceImpl_Roo_Service {
    
    declare @type: ProductChangeRequestServiceImpl: @Service;
    
    declare @type: ProductChangeRequestServiceImpl: @Transactional;
    
    public long ProductChangeRequestServiceImpl.countAllProductChangeRequests() {
        return productChangeRequestRepository.count();
    }
    
    public void ProductChangeRequestServiceImpl.deleteProductChangeRequest(ProductChangeRequest productChangeRequest) {
        productChangeRequestRepository.delete(productChangeRequest);
    }
    
    public ProductChangeRequest ProductChangeRequestServiceImpl.findProductChangeRequest(Long id) {
        return productChangeRequestRepository.findOne(id);
    }
    
    public List<ProductChangeRequest> ProductChangeRequestServiceImpl.findAllProductChangeRequests() {
        return productChangeRequestRepository.findAll();
    }
    
    public List<ProductChangeRequest> ProductChangeRequestServiceImpl.findProductChangeRequestEntries(int firstResult, int maxResults) {
        return productChangeRequestRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }
    
    public ProductChangeRequest ProductChangeRequestServiceImpl.updateProductChangeRequest(ProductChangeRequest productChangeRequest) {
        return productChangeRequestRepository.save(productChangeRequest);
    }
    
}