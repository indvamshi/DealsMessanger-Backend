package com.dealsmessanger.service;

import java.util.List;

import com.dealsmessanger.model.Business;
import com.dealsmessanger.model.Deal;

public interface BusinessService {

	Business saveBusiness();

	Business getBusinessById(String id);
	
	Business getBusinessByName(String name);
	
	Business getAllBusiness();
	
	List<Deal> getAllDeals(String businessName);
	
	void removeBusiness();
}
