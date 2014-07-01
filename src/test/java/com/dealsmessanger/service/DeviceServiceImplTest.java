package com.dealsmessanger.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dealsmessanger.model.Device;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/config/rest-services-config.xml" })
public class DeviceServiceImplTest {

	@Autowired
	private DeviceService deviceService;
	
	@Test
	public void shouldSaveNewDevice() {
		Device device = new Device();
		device.setBrand("htc");
		
		device = deviceService.saveDevice(device);
		
		device.setModel("htc-model");
		
		deviceService.saveDevice(device);
		
		device.setModel("htc-model1");
		
		deviceService.saveDevice(device);
		
		
	}
}
