package com.dealsmessanger.web;

//import static org.hamcrest.Matchers.equalTo;
//import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class DeviceControllerIT {

	public static final String JETTY_URI = "http://localhost:8080/dealsmessanger";
	
	@SuppressWarnings("rawtypes")
	@Test
	public void shouldReturnAllDevicesInJsonFormat() {
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap> programmes = restTemplate.getForObject(JETTY_URI+"/devices", List.class);

		Object object = programmes.get(0).get("deviceId");
		//assertThat(programmes,  hasSize(equalTo(6)));
	}
}
