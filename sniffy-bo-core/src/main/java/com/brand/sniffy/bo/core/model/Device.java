package com.brand.sniffy.bo.core.model;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.brand.sniffy.bo.core.utils.DeviceClass;
import javax.persistence.Enumerated;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.ManyToMany;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
@RooJson
public class Device {

    private static final String DEVICE_CLASS_JSON_FIELD = "deviceClass";

	/**
     */
    @NotNull
    @Column(unique = true)
    private String uuid;

    /**
     */
    @Enumerated
    private DeviceClass deviceClass;

    /**
     */
    private String pushToken;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "devices")
    private Set<User> users = new HashSet<User>();

	public JSONObject toJson() throws JSONException {
		JSONObject json = new JSONObject();
		json.put(DEVICE_CLASS_JSON_FIELD, deviceClass);
		return json;
	}
}
