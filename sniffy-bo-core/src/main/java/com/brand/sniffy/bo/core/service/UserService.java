package com.brand.sniffy.bo.core.service;
import org.springframework.roo.addon.layers.service.RooService;

import com.brand.sniffy.bo.core.model.User;

@RooService(domainTypes = { com.brand.sniffy.bo.core.model.User.class })
public interface UserService {

	User findUserByEmail(String email);

	User createUser(String device);

	User findUserByDevice(String string);
}
