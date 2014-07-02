package com.dealsmessanger.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dealsmessanger.model.Device;
import com.dealsmessanger.util.TestInMemoryMongo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/repository-context-test.xml" })
public class DeviceServiceImplTest extends TestInMemoryMongo {

	@Autowired
	private DeviceService deviceService;
	
	@Test
	public void shouldSaveNewDevice() {
		Device device = new Device();
		device.setBrand("htc");
		
		Assert.assertNotNull(deviceService.saveDevice(device));
	}
	
	@Test
	public void shouldUpdateDevice() {
		Device device = new Device();
		device.setBrand("htc");

		Device newDevice = deviceService.saveDevice(device);
		
		newDevice.setBrand("Samsung");
		
		Device updatedDevice = deviceService.saveDevice(newDevice);
		
		Assert.assertEquals(updatedDevice.getBrand(), "Samsung");
	}
	
}
