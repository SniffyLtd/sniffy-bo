package com.brand.sniffy.bo.core.model;

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
public class Category {

    private static final String ID_FIELD = "id";

    private static final String NAME_FIELD = "name";

    private String name;

    private long lastUpdate;

    public JSONObject toJson() throws JSONException {
        JSONObject category = new JSONObject();
        category.put(ID_FIELD, getId());
        category.put(NAME_FIELD, name);
        return category;
    }

    @Override
    public String toString() {
        return name;
    }
}
