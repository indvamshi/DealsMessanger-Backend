package com.dealsmessanger.service;

import java.util.List;

import com.dealsmessanger.model.Device;

public interface LocationService {

	List<Device> findDevicesBasedOnLocation();
	
	void pushDealToDevices();
}
