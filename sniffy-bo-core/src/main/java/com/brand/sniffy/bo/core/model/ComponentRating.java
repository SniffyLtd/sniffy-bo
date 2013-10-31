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
public class ComponentRating {

    private static final String COLOR_FIELD = "color";

    private static final String TITLE_FIELD = "title";

    private static final String DESCRIPTION_FIELD = "description";

    private static final String ID_FIELD = "id";

    private String title;

    private String color;

    private String description;

    private long lastUpdate;

    public JSONObject toJson() throws JSONException {
        JSONObject rating = new JSONObject();
        rating.put(ID_FIELD, this.getId());
        rating.put(COLOR_FIELD, color);
        rating.put(TITLE_FIELD, title);
        rating.put(DESCRIPTION_FIELD, description);
        return rating;
    }

    @Override
    public String toString() {
        return title;
    }
}
