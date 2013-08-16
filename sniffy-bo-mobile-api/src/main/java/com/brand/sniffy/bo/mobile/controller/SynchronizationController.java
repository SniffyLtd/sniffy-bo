package com.brand.sniffy.bo.mobile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/sync")
@Controller
public class SynchronizationController {

	@RequestMapping(method=RequestMethod.GET, value= "/init")
	public @ResponseBody String initialSynchronization(){
		
		return "success";
	}
	
	@RequestMapping(value="/{lastSynchronizationDate}")
	public @ResponseBody String  synchronization(@PathVariable Long lastSynchronizationDate){
		
		return "success";
	}
}
