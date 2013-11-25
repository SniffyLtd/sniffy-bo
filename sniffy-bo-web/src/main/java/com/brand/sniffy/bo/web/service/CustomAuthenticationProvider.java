package com.brand.sniffy.bo.web.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.brand.sniffy.bo.core.model.User;
import com.brand.sniffy.bo.core.service.UserService;
import com.brand.sniffy.bo.core.utils.UserRole;

public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	    String email = authentication.getName();
	    String password = (String)authentication.getCredentials();
	    
	    User user = userService.findUserByEmail(email);
	    if(user == null){
	    	 throw new BadCredentialsException("User not found.");
	    }
	    else if(!password.equals(user.getPassword())){
	    	 throw new BadCredentialsException("Password is wrong.");	
	    }
	    
	    Collection<UserRole> roles = user.getRoles();
	    Collection<GrantedAuthority> authorities  = new ArrayList<GrantedAuthority>();
	    for(UserRole role : roles){
	    	authorities.add(new SimpleGrantedAuthority(role.name()));
	    	
	    }
		
		return new UsernamePasswordAuthenticationToken("admin", "admin", authorities);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}
}
