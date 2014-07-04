// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.brand.sniffy.bo.core.service;

import com.brand.sniffy.bo.core.model.Device;
import com.brand.sniffy.bo.core.service.DeviceServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

privileged aspect DeviceServiceImpl_Roo_Service {
    
    declare @type: DeviceServiceImpl: @Service;
    
    declare @type: DeviceServiceImpl: @Transactional;
    
    public long DeviceServiceImpl.countAllDevices() {
        return deviceRepository.count();
    }
    
    public void DeviceServiceImpl.deleteDevice(Device device) {
        deviceRepository.delete(device);
    }
    
    public Device DeviceServiceImpl.findDevice(Long id) {
        return deviceRepository.findOne(id);
    }
    
    public List<Device> DeviceServiceImpl.findAllDevices() {
        return deviceRepository.findAll();
    }
    
    public List<Device> DeviceServiceImpl.findDeviceEntries(int firstResult, int maxResults) {
        return deviceRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }
    
    public void DeviceServiceImpl.saveDevice(Device device) {
        deviceRepository.save(device);
    }
    
    public Device DeviceServiceImpl.updateDevice(Device device) {
        return deviceRepository.save(device);
    }
    
}