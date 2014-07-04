package com.brand.sniffy.bo.core.service;

import javax.naming.AuthenticationException;

import com.brand.sniffy.bo.core.model.User;

public interface AuthenticationService {

	User authenticate(String userName, String password) throws AuthenticationException;

}
