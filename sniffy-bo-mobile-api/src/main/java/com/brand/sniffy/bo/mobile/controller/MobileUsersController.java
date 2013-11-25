package com.brand.sniffy.bo.mobile.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brand.sniffy.bo.core.model.User;
import com.brand.sniffy.bo.core.service.UserService;

@Controller
@RequestMapping("/user")
public class MobileUsersController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/{device}", method=RequestMethod.GET)
	public ResponseEntity<String> getApiKey(@PathVariable("device") String device){
		User user = userService.findUserByDevice("device");
		if(user == null){
			user = userService.createUser(device);
		}
		return new ResponseEntity<String>(user.getApiKey(), responseHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{email}/{password}/{device}", method= RequestMethod.GET)
	public ResponseEntity<String> getUserApiKey(@PathVariable("email") String email,@PathVariable("password") String password,@PathVariable("device") String device){
		return new ResponseEntity<String>(UUID.randomUUID().toString(), responseHeaders(), HttpStatus.OK);
	}
	
	private HttpHeaders responseHeaders() {
		HttpHeaders heders = new HttpHeaders();
		heders.set("Content-Type", "application/json;charset=UTF-8");
		return heders;
	}
}
