package com.dealsmessanger.service;

import java.util.List;

import com.dealsmessanger.model.Business;
import com.dealsmessanger.model.Deal;

public interface BusinessService {

	Business saveBusiness(Business business);

	Business getBusinessById(String id);
	
	Business getBusinessByName(String name);
	
	List<Business> getAllBusiness();
	
	List<Deal> getAllDeals(String businessName);
	
	void removeBusiness(String id);
	
	void removeAll();
}
