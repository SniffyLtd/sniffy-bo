package com.brand.sniffy.bo.mobile.controller;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brand.sniffy.bo.core.model.Device;
import com.brand.sniffy.bo.core.model.User;
import com.brand.sniffy.bo.core.service.AuthenticationService;
import com.brand.sniffy.bo.core.service.DeviceService;
import com.brand.sniffy.bo.core.service.UserService;
import com.brand.sniffy.bo.core.utils.DeviceClass;
import com.brand.sniffy.bo.core.utils.UserRole;
import com.brand.sniffy.bo.mobile.constants.SniffyHeaders;
import com.brand.sniffy.bo.mobile.domain.ClientContext;

import flexjson.JSONException;

@Controller
@RequestMapping("/user")
public class MobileUsersController {
	
	Logger LOG = Logger.getLogger(MobileUsersController.class.getName());

	@Autowired
	private UserService userService;
	
	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@RequestMapping(value="/register", method= RequestMethod.POST)
	public ResponseEntity<String> registerUser(@RequestBody String userJson) throws org.json.JSONException{
		
		User user = null;
		try{
			user = User.fromJsonToUser(userJson);
		}
		catch(IllegalArgumentException e){
			JSONObject response = new JSONObject();
			response.put("message", e.getMessage());
			LOG.warning(String.format("Bad user data.", user.getLogin()));
			return new ResponseEntity<String>(response.toString(), HttpStatus.BAD_REQUEST);
		}
		catch(JSONException e){
			JSONObject response = new JSONObject();
			response.put("message", e.getMessage());
			LOG.warning(String.format("Bad user data.", user.getLogin()));
			return new ResponseEntity<String>(response.toString(), HttpStatus.BAD_REQUEST);
		}
		
		try{
			userService.registerMobileUser(user);
		}
		catch(IllegalArgumentException e){
			JSONObject response = new JSONObject();
			response.put("message", e.getMessage());
			LOG.warning(String.format("Bad user data.", user.getLogin()));
			return new ResponseEntity<String>(response.toString(), HttpStatus.BAD_REQUEST);
		}
		catch (IllegalAccessException e){
			JSONObject response = new JSONObject();
			response.put("message", e.getMessage());
			LOG.warning(String.format("User '%s' already registered.", user.getLogin()));
			return new ResponseEntity<String>(response.toString(), HttpStatus.CONFLICT);
		}
		
		
		JSONObject response = new JSONObject();
		response.put("message", "");
		LOG.info(String.format("New user '%s' registered.", user.getLogin()));
		return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/device/register", method= RequestMethod.POST)
	public ResponseEntity<String> registerDevice(HttpServletRequest request, @RequestBody String deviceJson) throws org.json.JSONException{
		Device deviceToRegister = null;
		try{
			deviceToRegister = Device.fromJsonToDevice(deviceJson);
		}
		catch(IllegalArgumentException e){
			JSONObject response = new JSONObject();
			response.put("message", e.getMessage());
			return new ResponseEntity<String>(response.toString(), HttpStatus.BAD_REQUEST);
		}
		catch(JSONException e){
			JSONObject response = new JSONObject();
			response.put("message", e.getMessage());
			return new ResponseEntity<String>(response.toString(), HttpStatus.BAD_REQUEST);
		}
		User user = null;
		try
		{
			user = authenticationService.authenticate(request.getHeader(SniffyHeaders.USER_NAME_HEADER), request.getHeader(SniffyHeaders.USER_PASSWORD_HEADER ));
		}
		catch (AuthenticationException e){
			JSONObject response = new JSONObject();
			response.put("message", e.getMessage());
			return new ResponseEntity<String>(response.toString(), HttpStatus.UNAUTHORIZED);
		}
		
		if(!user.getRoles().contains(UserRole.MOBILE_USER)){
			JSONObject response = new JSONObject();
			response.put("message", "User has no permission to register device.");
			return new ResponseEntity<String>(response.toString(), HttpStatus.FORBIDDEN);
		}
		
		Device device = deviceService.findByUUID(deviceToRegister.getUuid());
		if(device != null && !deviceToRegister.getDeviceClass().equals(device.getDeviceClass())){
			JSONObject response = new JSONObject();
			response.put("message", "Device already exist and it is not given class.");
			return new ResponseEntity<String>(response.toString(), HttpStatus.CONFLICT);
		}
		else if(device == null){
			Device newDevice = new Device();
			newDevice.setDeviceClass(deviceToRegister.getDeviceClass());
			newDevice.setUuid(deviceToRegister.getUuid());
			device = deviceService.save(newDevice);
		}
		if(!user.getDevices().contains(device)){
			user.getDevices().add(device);
		}
		
		userService.save(user);
		JSONObject response = new JSONObject();
		response.put("message", "");
		return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/authenticate", method= RequestMethod.POST)
	public ResponseEntity<String> authenticateUser(ClientContext context) throws org.json.JSONException{
		
		if(context.getUser() != null && context.getDevice()!=null){
			JSONObject response = new JSONObject();
			response.put("message", "");
			LOG.info(String.format("User: '%s', device: '%s' authenticated.", context.getUser().getLogin(), context.getDevice().getUuid()));
			return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
		}
		
		JSONObject response = new JSONObject();
		response.put("message", "Unknown user or device.");
		LOG.warning(String.format("Unknown user or device. User: '%s', device: '%s'", context.getUser().getLogin(), context.getDevice().getUuid()));
		return new ResponseEntity<String>(response.toString(), HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) throws org.json.JSONException{
		JSONObject response = new JSONObject();
		response.put("message", e.getMessage());
		return new ResponseEntity<String>(response.toString(), HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalAccessException( IllegalArgumentException e) throws org.json.JSONException{
		JSONObject response = new JSONObject();
		response.put("message", e.getMessage());
		return new ResponseEntity<String>(response.toString(), HttpStatus.FORBIDDEN);
	}
	
}
