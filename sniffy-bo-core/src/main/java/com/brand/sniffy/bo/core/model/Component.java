package com.brand.sniffy.bo.core.model;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson(deepSerialize=false)
public class Component {

    private static final String ID_FIELD = "id";

    private static final String NAME_FIELD = "name";

    private static final String EQUIVALENT_NAMES_FIELD = "equivalentNames";

    private static final String RATING_FIELD = "rating_id";

    private String name;

    @ManyToOne
    @JoinColumn(name = "rating_id")
    private ComponentRating rating;

    @Column(length=1024)
    private String description;

    private String equivalentNames;

    private long lastUpdate;
    
    private long creationTime;
    
    private Boolean deleted;

    public JSONObject toJson() throws JSONException {
        JSONObject component = new JSONObject();
        component.put(ID_FIELD, this.getId());
        component.put(NAME_FIELD, name);
        component.put(EQUIVALENT_NAMES_FIELD, equivalentNames);
        if(rating != null){
        	component.put(RATING_FIELD, rating.getId());
        }
        return component;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     */
    private Boolean tmp;
}
