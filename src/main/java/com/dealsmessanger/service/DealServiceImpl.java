package com.dealsmessanger.service;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.Circle;
import org.springframework.stereotype.Service;

import com.dealsmessanger.gcm.Content;
import com.dealsmessanger.gcm.POST2GCM;
import com.dealsmessanger.model.Deal;
import com.dealsmessanger.model.Device;
import com.dealsmessanger.repository.DeviceRepository;

@Service
public class DealServiceImpl implements DealsService {

    private static final Logger logger = LoggerFactory.getLogger(DealServiceImpl.class);
    
    private static final String API_KEY = "AIzaSyB8xZvhcDmfPU3BknElkHnS1WDrILlXubs";

    @Autowired
    private MongoTemplate mongoTemplate;
    
	@Autowired
	private DeviceRepository deviceRepository;
	
	public List<Deal> getDeals() {
		return mongoTemplate.findAll(Deal.class);
	}

	public Deal saveDeal(Deal deal) {
		if (deal.getDealId() == null) {
			deal.setDealId(UUID.randomUUID().toString());
		}
		mongoTemplate.save(deal);
		
		List<Device> deviceList = findDevicesBasedOnLocation(deal);
		
		// for testing send notifications to all devices...
		//sendNotification(deviceRepository.findAll());
		if (deviceList.size() > 0) {
			
			logger.debug("sending notifications to devices size :"+deviceList.size());
			
			sendNotification(deviceRepository.findAll());
			
		}
		return deal;
	}

	private void sendNotification(List<Device> devices) {
		// TODO Auto-generated method stub
		
		for(Device device : devices) {
			Content content = new Content();

			content.addRegId(device.getGcmRegId());
			content.createData("Test Title", "Test Message");
	        String result = POST2GCM.post(API_KEY, content);
	        
	        logger.debug("result from GCM--------->>>>>>>>>>>>>>>>>"+result);
		}
       
	}

	public void deleteAllDeals() {
		mongoTemplate.dropCollection(Deal.class);;
	}

	public List<Device> findDevicesBasedOnLocation(Deal deal) {
		Circle circle = new Circle(deal.getLocation()[0], deal.getLocation()[1], deal.getRadius());
		
		return deviceRepository.findByLocationWithin(circle);
	}

}
