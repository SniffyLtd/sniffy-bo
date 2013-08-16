// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.brand.sniffy.bo.core.model;

import com.brand.sniffy.bo.core.model.Component;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Component_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Component.entityManager;
    
    public static final EntityManager Component.entityManager() {
        EntityManager em = new Component().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Component.countComponents() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Component o", Long.class).getSingleResult();
    }
    
    public static List<Component> Component.findAllComponents() {
        return entityManager().createQuery("SELECT o FROM Component o", Component.class).getResultList();
    }
    
    public static Component Component.findComponent(Long id) {
        if (id == null) return null;
        return entityManager().find(Component.class, id);
    }
    
    public static List<Component> Component.findComponentEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Component o", Component.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Component.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Component.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Component attached = Component.findComponent(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Component.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Component.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Component Component.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Component merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
