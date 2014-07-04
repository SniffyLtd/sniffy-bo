package com.brand.sniffy.bo.core.service;
import org.springframework.roo.addon.layers.service.RooService;

import com.brand.sniffy.bo.core.model.Device;

@RooService(domainTypes = { com.brand.sniffy.bo.core.model.Device.class })
public interface DeviceService {

	Device findByUUID(String uuid);

	Device save(Device device);
}
