package com.brand.sniffy.bo.core.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Producer {

    private String name;

    private String contactPerson;

    private String phone;

    private String fax;

    private String email;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    private String code;
}
