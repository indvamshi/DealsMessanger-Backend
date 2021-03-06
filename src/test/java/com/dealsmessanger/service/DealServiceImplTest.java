package com.dealsmessanger.service;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dealsmessanger.model.Deal;
import com.dealsmessanger.util.TestInMemoryMongo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/repository-context-test.xml" })
@Ignore
public class DealServiceImplTest extends TestInMemoryMongo {

	@Autowired
	private DealsService dealsService;
	
	@Test
	public void shouldSaveDeal() {
		Deal deal = new Deal();
		deal.setLocation(new double[]{51.4449256, -0.4118861});
		Assert.assertNotNull(dealsService.saveDeal(deal));
	}
}
