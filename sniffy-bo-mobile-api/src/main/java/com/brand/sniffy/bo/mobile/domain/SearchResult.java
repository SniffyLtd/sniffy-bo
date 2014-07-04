package com.brand.sniffy.bo.mobile.domain;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.json.RooJson;

import com.brand.sniffy.bo.core.model.Device;
import com.brand.sniffy.bo.core.model.Product;


@RooJavaBean
@RooJson(deepSerialize=true)
public class SearchResult {

	private static final String BARCODE_JSON_FIELD = "barcode";

	private static final String PRODUCT_NAME_JSON_FIELD = "productName";

	private static final String PRODUCT_JSON_FIELD = "product";

	private static final String DEVICE_JSON_FIELD = "device";

	private static final String REQUEST_TIME_JSON_FIELD = "requestTime";

	private String barcode;
	
	private String productName;
	
	private Product product;
	
	private Device device;
	
	private Date requestTime;
	
	public JSONObject toJson() throws JSONException {
		JSONObject json = new JSONObject();
		json.put(BARCODE_JSON_FIELD, barcode);
		json.put(PRODUCT_NAME_JSON_FIELD, productName);
		if(product != null){
			json.put(PRODUCT_JSON_FIELD, product.toJson());
		}
		json.put(DEVICE_JSON_FIELD, device.toJson());
		json.put(REQUEST_TIME_JSON_FIELD, requestTime);
		return json;
	}
}
