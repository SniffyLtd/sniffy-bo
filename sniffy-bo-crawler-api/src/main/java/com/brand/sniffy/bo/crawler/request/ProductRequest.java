package com.brand.sniffy.bo.crawler.request;
import org.springframework.roo.addon.json.RooJson;

import org.springframework.roo.addon.javabean.RooJavaBean;

@RooJson
@RooJavaBean
public class ProductRequest {

    /**
     */
    private String name;

    /**
     */
    private String description;

    /**
     */
    private String price;

    /**
     */
    private String components;

    /**
     */
    private String url;

    /**
     */
    private String producerName;

    /**
     */
    private String barcode;

	public ProductRequest clearProducerName() {
		if(producerName != null){
			producerName = producerName.trim();
		}
		return this;
	}

	public ProductRequest clearName() {
		if(name!=null){
			name = name.trim();
			if(producerName!=null){
				name = name.replace(producerName, "").trim();
			}
		}
		return this;
	}

	public ProductRequest clearPrice() {
		if(price != null){
			price = price.replaceAll("[^0-9\\.,]", "");
		}
		return this;
	}

}
