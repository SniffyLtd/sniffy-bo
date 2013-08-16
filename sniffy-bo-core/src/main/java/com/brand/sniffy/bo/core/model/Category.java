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

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    /**
     */
    private long lastUpdate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Category> subcategories = new HashSet<Category>();
}
