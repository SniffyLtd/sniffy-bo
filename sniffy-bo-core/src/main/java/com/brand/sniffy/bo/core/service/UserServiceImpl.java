package com.brand.sniffy.bo.core.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.brand.sniffy.bo.core.model.User;
import com.brand.sniffy.bo.core.repository.UserRepository;
import com.brand.sniffy.bo.core.utils.UserRole;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findUserByLogin(String login) {
		return userRepository.findByLogin(login);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User registerMobileUser(User user) throws IllegalAccessException{
		if(StringUtils.isBlank(user.getLogin())){
			throw new IllegalArgumentException("User name required");
		}
		if(StringUtils.isBlank(user.getPassword())){
			throw new IllegalArgumentException("Password required");
		}
		if(findUserByLogin(user.getLogin()) != null){
			throw new IllegalAccessException("User already exists.");
		}
		user.getRoles().clear();
		user.getRoles().add(UserRole.MOBILE_USER);
		return save(user);
	}
}
