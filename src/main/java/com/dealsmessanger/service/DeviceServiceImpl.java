package com.dealsmessanger.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.dealsmessanger.model.Device;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public Device saveDevice(Device device) {
		if (device.getDeviceId() == null) {
			device.setDeviceId(UUID.randomUUID().toString());
			device.setCreated(new Date());
		}
		device.setUpdated(new Date());
		mongoTemplate.save(device);
		
		System.out.println("Device information :::::::::::::::" +device.toString());
		return device;
	}

	@Override
	public List<Device> getDevices() {
		return mongoTemplate.findAll(Device.class);
	}
}
