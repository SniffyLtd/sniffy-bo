package com.brand.sniffy.bo.core.model;

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
@RooJson
public class Producer {

    private static final String ID_FIELD = "id";

    private static final String NAME_FIELD = "name";

    private static final String CONTACT_PERSON_FIELD = "contactPerson";

    private static final String PHONE_FIELD = "phone";

    private static final String FAX_FIELD = "fax";

    private static final String EMAIL_FIELD = "email";

    private static final String COUNTRY_ID_FIELD = "country_id";

    private static final String CODE_FIELD = "code";

    private String name;

    private String contactPerson;

    private String phone;

    private String fax;

    private String email;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    private String code;

    private long lastUpdate;

    public JSONObject toJson() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(ID_FIELD, getId());
        json.put(NAME_FIELD, name);
        json.put(CONTACT_PERSON_FIELD, contactPerson);
        json.put(PHONE_FIELD, phone);
        json.put(FAX_FIELD, fax);
        json.put(EMAIL_FIELD, email);
        json.put(COUNTRY_ID_FIELD, country.getId());
        json.put(CODE_FIELD, code);
        return json;
    }

    @Override
    public String toString() {
        return name;
    }
}
