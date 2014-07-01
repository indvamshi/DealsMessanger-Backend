package com.dealsmessanger.service;

import java.util.List;

import com.dealsmessanger.model.Device;

public interface DeviceService {

	Device saveDevice(Device device);
	
	List<Device> getDevices();

}
