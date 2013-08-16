package com.brand.application.bo.crawler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/test")
@Controller
public class TestController {
	
	@RequestMapping(method=RequestMethod.GET, value="/init")
	public @ResponseBody String initial(){
		return "success";
	}

}
