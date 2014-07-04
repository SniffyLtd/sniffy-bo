package com.brand.sniffy.bo.core.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.brand.sniffy.bo.core.model.Device;
import com.brand.sniffy.bo.core.repository.DeviceRepository;

public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceRepository deviceRepository;
	
	@Override
	public Device findByUUID(String uuid) {
		
		return deviceRepository.findByUuid(uuid);
	}

	@Override
	public Device save(Device device) {
		return deviceRepository.save(device);
	}
}
