package com.dealsmessanger.service;

import java.util.List;

import com.dealsmessanger.model.Deal;

public interface DealsService {

	List<Deal> getDeals();
	
	Deal getDeal();
	
	Deal saveDeal(Deal deal);

	void deleteAllDeals();

}
