package com.brand.sniffy.bo.core.model;

import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

import javax.persistence.Column;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson
public class Country {

    private static final String ID_FIELD = "id";

    private static final String NAME_FIELD = "name";

    private static final String CODE_FIELD = "code";

    private String code;

    private long lastUpdate;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="country",orphanRemoval=true, fetch = FetchType.LAZY)
    private Set<Producer> producers;

    @Column(unique = true)
    private String name;

    public JSONObject toJson() throws JSONException {
        JSONObject country = new JSONObject();
        country.put(ID_FIELD, this.getId());
        country.put(NAME_FIELD, name);
        country.put(CODE_FIELD, code);
        return country;
    }

    @Override
    public String toString() {
        return name;
    }
}
