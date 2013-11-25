package com.brand.sniffy.bo.core.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.brand.sniffy.bo.core.model.User;
import com.brand.sniffy.bo.core.repository.UserRepository;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User createUser(String device) {
		User user = new User();
		List<String> devices = new ArrayList<String>();
		devices.add(device);
		user.setDevices(devices);
		user.setApiKey(UUID.randomUUID().toString());
		return userRepository.save(user);
	}

	@Override
	public User findUserByDevice(String device) {
		return userRepository.findByDevices(device);
	}
}
