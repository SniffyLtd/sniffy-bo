package com.brand.sniffy.bo.crawler.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/product")
@Controller
public class ProductCrawlerController {
	
	@RequestMapping(method=RequestMethod.POST, value="/request")
	public @ResponseBody String request(@RequestBody String data){
		
		return "success";
	}
}
