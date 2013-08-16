package com.brand.sniffy.bo.core.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Product {

    private static final String NAME_FIELD = "name";

	private static final String BARCODE_FIELD = "barcode";

	private static final String DESCRIPTION_FIELD = "description";

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

	public JSONObject toJson() {
		JSONObject product = new JSONObject();
		try {
			product.put(NAME_FIELD, name);
			product.put(BARCODE_FIELD, barcode);
			product.put(DESCRIPTION_FIELD, description);

		} catch (JSONException e) {
			throw new IllegalStateException(e);
		}
		return product;
	}
}
