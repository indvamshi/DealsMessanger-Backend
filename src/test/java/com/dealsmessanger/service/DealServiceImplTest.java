package com.dealsmessanger.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dealsmessanger.model.Deal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/config/rest-services-config.xml" })
public class DealServiceImplTest {

	@Autowired
	private DealsService dealsService;
	
	@Test
	public void shouldSaveDeal() {
		Deal deal = new Deal();
		deal.setLocation(new double[]{51.4449256, -0.4118861});
		dealsService.saveDeal(deal);
	}
}
