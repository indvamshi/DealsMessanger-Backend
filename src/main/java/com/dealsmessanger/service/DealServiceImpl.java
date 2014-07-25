package com.dealsmessanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
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
	
	@Override
	public List<Deal> getDeals() {
		return mongoTemplate.findAll(Deal.class);
	}

	@Override
	public Deal saveDeal(Deal deal) {
		if (StringUtils.isBlank(deal.getDealId())) {
			deal.setDealId(UUID.randomUUID().toString());
		}
		mongoTemplate.save(deal);
		
		List<Device> deviceList = findDevicesBasedOnLocation(deal);
		
		if (deviceList.size() > 0) {
			
			logger.debug("sending notifications to devices size :"+deviceList.size());
			
			sendNotification(deviceRepository.findAll(), deal);
			
		}
		return deal;
	}

	private void sendNotification(List<Device> devices, Deal deal) {
		// TODO Auto-generated method stub
		List<String> regIdList = new ArrayList<String>();
		for(Device device : devices) {
			regIdList.add(device.getGcmRegId());
		}
		
		Content content = new Content();
		
		content.getRegistration_ids().addAll(regIdList);
		content.createData("msg", deal.getDealDescription());
		content.createData("lati", Double.toString(deal.getLocation()[1]));
		content.createData("longi", Double.toString(deal.getLocation()[0]));
		content.createData("radius", Double.toString(deal.getRadius()));
		
		// assuming the expiry time set in UI is in minutes format, so 
		// convert into milliseconds
		content.createData("exp", Long.toString(TimeUnit.MINUTES.toMillis(2)));
		content.createData("dealId", deal.getDealId());
        String result = POST2GCM.post(API_KEY, content);
        
        logger.debug("result from GCM--------->>>>>>>>>>>>>>>>>"+result);

/*		for(Device device : devices) {
			Content content = new Content();
			
			content.addRegId(device.getGcmRegId());
			content.createData("msg", deal.getDealDescription());
			content.createData("lati", Double.toString(deal.getLocation()[1]));
			content.createData("longi", Double.toString(deal.getLocation()[0]));
			content.createData("radius", Double.toString(deal.getRadius()));
			content.createData("exp", Double.toString(50000));
			content.createData("dealId", deal.getDealId());
	        String result = POST2GCM.post(API_KEY, content);
	        
	        logger.debug("result from GCM--------->>>>>>>>>>>>>>>>>"+result);
		}*/
       
	}

	@Override
	public void deleteAllDeals() {
		mongoTemplate.dropCollection(Deal.class);;
	}

	private List<Device> findDevicesBasedOnLocation(Deal deal) {
		Circle circle = new Circle(deal.getLocation()[1], deal.getLocation()[0], deal.getRadius());
		
		return deviceRepository.findByLocationWithin(circle);
	}

	@Override
	public Deal getDealInfo(String id) {
		return mongoTemplate.findById(id, Deal.class);
	}

}
