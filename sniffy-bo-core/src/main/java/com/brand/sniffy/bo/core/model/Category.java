package com.brand.sniffy.bo.core.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Category {

    @ManyToOne
    @JoinColumn(name = "category_id")
    private com.brand.sniffy.bo.core.model.Category category;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<com.brand.sniffy.bo.core.model.Category> subcategories = new HashSet<com.brand.sniffy.bo.core.model.Category>();

    private String name;
}
