package com.brand.application.bo.mobile.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brand.application.bo.core.model.Product;
import com.brand.application.bo.core.repository.ProductRepository;


@RequestMapping("/product")
@Controller
public class ProductSyncController {
	
	private static final String STATUS_FIELD = "status";
	
	private static final String SUCCESS_STATUS = "SUCCESS";

	private static final String PRODUCT_FIELD = "product";

	private static final String NOT_FOUND = "NOT_FOUND";
	
	@Autowired
	private ProductRepository productRepository;

	@RequestMapping("/{id}/sync/{lastSynchronizationDate}")
	public @ResponseBody String synchronizeProduct(@PathVariable Long id, @PathVariable Long lastSynchronizationDate){
		
		return "success";
	}
	
	@RequestMapping(value = "/sync", method= RequestMethod.POST)
	public @ResponseBody String synchronizeProducts(@RequestBody String productsData){
		
		return "success";
	}
	
	@RequestMapping(value = "/find/{barcode}", method= RequestMethod.GET)
	public @ResponseBody String findProduct(@PathVariable String barcode) throws JSONException{
		
		Product product = productRepository.findByBarcode(barcode);
		if(product != null){
			JSONObject result = new JSONObject();
			result.put(STATUS_FIELD, SUCCESS_STATUS);
			result.put(PRODUCT_FIELD, product.toJson());
			return result.toString();
		}
		else{
			JSONObject result = new JSONObject();
			result.put(STATUS_FIELD, NOT_FOUND);
			return result.toString();
		}
	}
	
}
