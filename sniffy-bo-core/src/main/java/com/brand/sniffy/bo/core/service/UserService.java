package com.brand.sniffy.bo.core.service;
import org.springframework.roo.addon.layers.service.RooService;

import com.brand.sniffy.bo.core.model.User;

@RooService(domainTypes = { com.brand.sniffy.bo.core.model.User.class })
public interface UserService {

	User findUserByEmail(String email);

	User findUserByLogin(String login);

	User save(User user);

	User registerMobileUser(User user) throws IllegalAccessException;
}
