package com.brand.sniffy.bo.crawler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.brand.sniffy.bo.crawler.request.ProductRequest;
import com.brand.sniffy.bo.crawler.service.ProductRequestProcessor;

@RequestMapping("/product")
@Controller
public class ProductCrawlerController {
	
	@Autowired
	private ProductRequestProcessor productRequestProcessor;
	
	@RequestMapping(method=RequestMethod.POST, value="/request")
	@ResponseStatus(value=HttpStatus.OK)
	public void request(@RequestBody String json){
		ProductRequest productRequest= ProductRequest.fromJsonToProductRequest(json);
		
		productRequestProcessor.processRequest(productRequest);
	}
}
