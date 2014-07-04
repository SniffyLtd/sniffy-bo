package com.brand.sniffy.bo.core.repository;
import com.brand.sniffy.bo.core.model.Device;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Device.class)
public interface DeviceRepository {

	Device findByUuid(String uuid);
}
