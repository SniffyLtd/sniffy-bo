package com.brand.sniffy.bo.core.model;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Country {

    private String code;

    /**
     */
    private long lastUpdate;

    /**
     */
    @Column(unique = true)
    private String name;
}
