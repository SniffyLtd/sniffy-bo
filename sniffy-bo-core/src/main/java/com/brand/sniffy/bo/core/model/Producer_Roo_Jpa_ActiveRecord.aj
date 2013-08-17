// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.brand.sniffy.bo.core.model;

import com.brand.sniffy.bo.core.model.Producer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Producer_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Producer.entityManager;
    
    public static final EntityManager Producer.entityManager() {
        EntityManager em = new Producer().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Producer.countProducers() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Producer o", Long.class).getSingleResult();
    }
    
    public static List<Producer> Producer.findAllProducers() {
        return entityManager().createQuery("SELECT o FROM Producer o", Producer.class).getResultList();
    }
    
    public static Producer Producer.findProducer(Long id) {
        if (id == null) return null;
        return entityManager().find(Producer.class, id);
    }
    
    public static List<Producer> Producer.findProducerEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Producer o", Producer.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Producer.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Producer.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Producer attached = Producer.findProducer(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Producer.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Producer.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Producer Producer.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Producer merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}