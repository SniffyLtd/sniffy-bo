package com.brand.sniffy.bo.core.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Component {

    private String name;

    private String equivalentName;

    private String equivalentNames;

    @ManyToOne
    @JoinColumn(name = "rating_id")
    private ComponentRating rating;
}
