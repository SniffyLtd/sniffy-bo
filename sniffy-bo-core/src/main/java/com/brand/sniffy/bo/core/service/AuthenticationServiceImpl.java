package com.brand.sniffy.bo.core.service;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brand.sniffy.bo.core.model.User;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	private UserService userService;
	
	@Override
	public User authenticate(String userName, String password) throws AuthenticationException {
		
		User user = userService.findUserByLogin(userName);
		if(user == null){
			user = userService.findUserByEmail(userName);
		}
		if(user == null || !password.equals(user.getPassword())){
			throw new AuthenticationException("Authorization exception.");
		}
		return user;
	}

}
