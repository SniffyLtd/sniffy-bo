// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.brand.sniffy.bo.core.model;

import com.brand.sniffy.bo.core.model.ProductChangeRequest;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect ProductChangeRequest_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager ProductChangeRequest.entityManager;
    
    public static final EntityManager ProductChangeRequest.entityManager() {
        EntityManager em = new ProductChangeRequest().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long ProductChangeRequest.countProductChangeRequests() {
        return entityManager().createQuery("SELECT COUNT(o) FROM ProductChangeRequest o", Long.class).getSingleResult();
    }
    
    public static List<ProductChangeRequest> ProductChangeRequest.findAllProductChangeRequests() {
        return entityManager().createQuery("SELECT o FROM ProductChangeRequest o", ProductChangeRequest.class).getResultList();
    }
    
    public static ProductChangeRequest ProductChangeRequest.findProductChangeRequest(Long id) {
        if (id == null) return null;
        return entityManager().find(ProductChangeRequest.class, id);
    }
    
    public static List<ProductChangeRequest> ProductChangeRequest.findProductChangeRequestEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM ProductChangeRequest o", ProductChangeRequest.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void ProductChangeRequest.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void ProductChangeRequest.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            ProductChangeRequest attached = ProductChangeRequest.findProductChangeRequest(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void ProductChangeRequest.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void ProductChangeRequest.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public ProductChangeRequest ProductChangeRequest.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        ProductChangeRequest merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
