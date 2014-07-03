package com.dealsmessanger.service;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dealsmessanger.model.Business;
import com.dealsmessanger.model.BusinessAddress;
import com.dealsmessanger.util.TestInMemoryMongo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/repository-context-test.xml" })
public class BusinessServiceImplTest extends TestInMemoryMongo {

	@Autowired
	private BusinessService businessService;

	@Test
	public void shouldSaveBusinessDetails() {

		Business newBusiness = businessService
				.saveBusiness(getBusinessDetails());

		Assert.assertNotNull(newBusiness);
		Assert.assertEquals("Tesco", newBusiness.getName());
	}

	@Test
	public void shouldSaveBusinessDetailsAndAddress() {
		Business business = getBusinessDetails();
		business.setBusinessAddress(getBusinessAddress());

		Business newBusiness = businessService.saveBusiness(business);
		
		Assert.assertNotNull(newBusiness);
		Assert.assertNotNull(newBusiness.getBusinessAddress());
		Assert.assertEquals("Tw13 4Gs", newBusiness.getBusinessAddress().getPostCode());
	}

	private Business getBusinessDetails() {
		Business business = new Business();
		business.setName("Tesco");
		business.setPassword("password1");
		business.setVouchercode("12345");
		business.setCreatedTime(Calendar.getInstance().getTime());

		return business;
	}
	
	private BusinessAddress getBusinessAddress() {
		BusinessAddress address = new BusinessAddress();
		
		address.setHouseNo("117");
		address.setFirstLine("firstline1");
		address.setSecondLine("secondline1");
		address.setCity("");
		address.setPostCode("Tw13 4Gs");
		address.setState("Middlesex");
		address.setCountry("UK");
		address.setTelephone1("07507825263");
		address.setFax("07507825263");
		address.setEmail("test@gmail.com");
		address.setWebsite("tesco.co.uk");
		
		return address;
		
	}

}
