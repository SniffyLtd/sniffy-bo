package com.brand.sniffy.bo.core.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.json.JSONArray;
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
public class Product {

    private static final String NAME_FIELD = "name";

    private static final String BARCODE_FIELD = "barcode";

    private static final String DESCRIPTION_FIELD = "description";

    private static final String CATEGORY_ID_FIELD = "category_id";

    private static final String COMPONENTS_LIST_FIELD = "components";

    private static final String ID_FIELD = "id";

    private static final String PRODUCER_FIELD = "producer";

    private String barcode;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Component> components = new HashSet<Component>();

    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;

    private long lastUpdate;

    private String equivalentNames;

    public JSONObject toJson() throws JSONException {
        JSONObject product = new JSONObject();
        product.put(ID_FIELD, getId());
        product.put(NAME_FIELD, name);
        product.put(BARCODE_FIELD, barcode);
        product.put(DESCRIPTION_FIELD, description);
        product.put(CATEGORY_ID_FIELD, category.getId());
        product.put(PRODUCER_FIELD, producer.toJson());
        JSONArray componentsIds = new JSONArray();
        for (Component component : components) {
            componentsIds.put(component.getId());
        }
        product.put(COMPONENTS_LIST_FIELD, componentsIds);
        return product;
    }

    @Override
    public String toString() {
        if (producer != null) {
            return producer.getName() + " " + name;
        }
        return name;
    }
}
