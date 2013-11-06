package com.brand.sniffy.bo.core.utils;

import org.springframework.roo.addon.javabean.RooJavaBean;


@RooJavaBean
public class ProductMergeRequest {
	
	public enum Type {
		overwrite, discard, merge
	}

	private Long productChangeRequest;
	
	private boolean barcode;
	
	private boolean name;
	
	private Type components;
	
	private boolean producer;
	
	private boolean category;
	
	private Type description;
}
