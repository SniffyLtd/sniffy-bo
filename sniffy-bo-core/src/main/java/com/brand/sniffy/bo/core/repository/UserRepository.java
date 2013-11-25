package com.brand.sniffy.bo.core.repository;
import com.brand.sniffy.bo.core.model.User;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = User.class)
public interface UserRepository {

	User findByEmail(String email);

	User findByDevices(String device);
}
