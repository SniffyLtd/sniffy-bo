// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.brand.sniffy.bo.core.model;

import com.brand.sniffy.bo.core.model.SearchRequest;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect SearchRequest_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager SearchRequest.entityManager;
    
    public static final EntityManager SearchRequest.entityManager() {
        EntityManager em = new SearchRequest().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long SearchRequest.countSearchRequests() {
        return entityManager().createQuery("SELECT COUNT(o) FROM SearchRequest o", Long.class).getSingleResult();
    }
    
    public static List<SearchRequest> SearchRequest.findAllSearchRequests() {
        return entityManager().createQuery("SELECT o FROM SearchRequest o", SearchRequest.class).getResultList();
    }
    
    public static SearchRequest SearchRequest.findSearchRequest(Long id) {
        if (id == null) return null;
        return entityManager().find(SearchRequest.class, id);
    }
    
    public static List<SearchRequest> SearchRequest.findSearchRequestEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM SearchRequest o", SearchRequest.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void SearchRequest.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void SearchRequest.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            SearchRequest attached = SearchRequest.findSearchRequest(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void SearchRequest.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void SearchRequest.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public SearchRequest SearchRequest.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        SearchRequest merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}