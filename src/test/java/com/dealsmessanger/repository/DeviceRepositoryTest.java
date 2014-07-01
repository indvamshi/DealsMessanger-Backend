package com.dealsmessanger.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.Circle;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dealsmessanger.model.Deal;
import com.dealsmessanger.model.Device;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/config/repository-context.xml" })
public class DeviceRepositoryTest {

	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Test
	public void testBean() {
		Assert.assertNotNull(deviceRepository);
	}
	
	@Test
	public void shouldReturnDevicesLocatedInThisLocation() {
		Circle c = new Circle(51.4470292, -0.4464063, 1);
		
		Deal deal = new Deal();
		deal.setLocation(new double[]{51.4570292, -0.4564063});
		mongoTemplate.save(deal);
		
		List<Device> findByLocationWithin = deviceRepository.findByLocationWithin(c);
		
		Assert.assertTrue(findByLocationWithin.size() > 0);
	}
	
	@Test
	public void shouldReturnEmptyDevicesLocatedInThisLocation() {
		Circle c = new Circle(41.4470292, -0.3464063, 1);
		
		Deal deal = new Deal();
		deal.setLocation(new double[]{51.4570292, -0.4564063});
		mongoTemplate.save(deal);
		
		List<Device> findByLocationWithin = deviceRepository.findByLocationWithin(c);
		
		Assert.assertTrue(findByLocationWithin.size() == 0);
	}
}
