package com.dealsmessanger.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.dealsmessanger.model.Deal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/config/repository-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class DealRepositoryTest {

	@Autowired
	private DealRepository dealRepository;
	
	@Test
	public void shouldSaveDeal() {
		Deal deal = new Deal();
		deal.setRadius(1);
		
		dealRepository.saveDeal(deal);
	}
}
