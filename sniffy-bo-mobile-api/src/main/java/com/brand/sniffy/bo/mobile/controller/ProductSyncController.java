package com.brand.sniffy.bo.mobile.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.brand.sniffy.bo.core.model.Product;
import com.brand.sniffy.bo.core.repository.ProductRepository;


@RequestMapping("/product")
@Controller
public class ProductSyncController {
	

	private static final String PRODUCT_FIELD = "product";

	private static final String REASON_FIELD = "reason";
	
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
	public ResponseEntity<String> findProduct(@PathVariable String barcode) throws JSONException{
		try{
			Product product = productRepository.findByBarcode(barcode);
			if(product != null){
				JSONObject result = new JSONObject();
				result.put(PRODUCT_FIELD, product.toJson());
				return new ResponseEntity<String>(result.toString(), responseHeaders(), HttpStatus.OK);
			}
			else{
				JSONObject result = new JSONObject();
				result.put("requestBarcode", barcode);
				return new ResponseEntity<String>(result.toString(), responseHeaders(), HttpStatus.NOT_FOUND);
			}
		}
		catch(JSONException e){
			JSONObject response = new JSONObject();
			response.put(REASON_FIELD, e.getMessage());
			return new ResponseEntity<String>(response.toString(), responseHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private HttpHeaders responseHeaders() {
		HttpHeaders heders = new HttpHeaders();
		heders.set("Content-Type", "application/json;charset=UTF-8");
		return heders;
	}
	
	
	
}
