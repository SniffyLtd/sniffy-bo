// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.brand.sniffy.bo.core.repository;

import com.brand.sniffy.bo.core.model.Producer;
import com.brand.sniffy.bo.core.repository.ProducerRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

privileged aspect ProducerRepository_Roo_Jpa_Repository {
    
    declare parents: ProducerRepository extends JpaRepository<Producer, Long>;
    
    declare parents: ProducerRepository extends JpaSpecificationExecutor<Producer>;
    
    declare @type: ProducerRepository: @Repository;
    
}
