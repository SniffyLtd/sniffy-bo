// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.brand.sniffy.bo.core.repository;

import com.brand.sniffy.bo.core.model.ProductChangeRequest;
import com.brand.sniffy.bo.core.repository.ProductChangeRequestRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

privileged aspect ProductChangeRequestRepository_Roo_Jpa_Repository {
    
    declare parents: ProductChangeRequestRepository extends JpaRepository<ProductChangeRequest, Long>;
    
    declare parents: ProductChangeRequestRepository extends JpaSpecificationExecutor<ProductChangeRequest>;
    
    declare @type: ProductChangeRequestRepository: @Repository;
    
}
