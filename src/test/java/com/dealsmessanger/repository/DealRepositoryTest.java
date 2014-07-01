package com.dealsmessanger.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.dealsmessanger.model.Deal;
import com.dealsmessanger.service.DealsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/config/rest-services-config.xml" })
public class DealRepositoryTest {

	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Autowired
	DealsService dealsService;
	
	@Test
	public void shouldSaveDeal() {
		System.out.println("dealrepository :"+deviceRepository);
	}
}
