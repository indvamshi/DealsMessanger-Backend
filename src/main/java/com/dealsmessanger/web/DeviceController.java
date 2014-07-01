package com.dealsmessanger.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dealsmessanger.model.Device;
import com.dealsmessanger.service.DeviceService;

@Controller
public class DeviceController {

	private static final Logger logger = LoggerFactory.getLogger(DealsController.class);

	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping(value = "/device", method = RequestMethod.POST)
	@ResponseStatus( HttpStatus.OK )
	public @ResponseBody Device saveDevice(@RequestBody Device device) {
		logger.debug(String.format("Device details %s", device.toString()));
		return deviceService.saveDevice(device);
	}
	
	@RequestMapping(value = "/devices", method = RequestMethod.GET)
	public @ResponseBody List<Device> getRegisteredDevices() {
		return deviceService.getDevices();
	}
}
