package com.brand.sniffy.bo.mobile.handler;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.brand.sniffy.bo.core.model.Device;
import com.brand.sniffy.bo.core.model.User;
import com.brand.sniffy.bo.core.service.AuthenticationService;
import com.brand.sniffy.bo.core.service.DeviceService;
import com.brand.sniffy.bo.core.service.UserService;
import com.brand.sniffy.bo.core.utils.UserRole;
import com.brand.sniffy.bo.mobile.constants.SniffyHeaders;
import com.brand.sniffy.bo.mobile.domain.ClientContext;

public class UserDeviceArgumentResolver implements HandlerMethodArgumentResolver{

	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private DeviceService deviceService;

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterType().equals(ClientContext.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		
		String login = getHeader(webRequest, SniffyHeaders.USER_NAME_HEADER); 
		String password = getHeader(webRequest, SniffyHeaders.USER_PASSWORD_HEADER); 
		String deviceUUID = getHeader(webRequest, SniffyHeaders.DEVICE_UUID_HEADER); 

		User user = authenticationService.authenticate(login, password);
		if(!user.getRoles().contains(UserRole.MOBILE_USER)){
			throw new AuthenticationException("User don't have access for that operation.");
		}

		Device device = deviceService.findByUUID(deviceUUID);
		if(device == null){
			throw new IllegalArgumentException("Unknown device.");
		}
		
		if(!user.getDevices().contains(device)){
			throw new IllegalArgumentException("Device do not belongs to this user.");
		}
		
		return new ClientContext(user, device);
	}

	  private String getHeader(final NativeWebRequest webRequest, final String header) {
          String headerValue = webRequest.getHeader(header);
          if (headerValue == null) {
                  throw new IllegalArgumentException("'" + header + "' header not present");
          }
          return headerValue;
  }
}
