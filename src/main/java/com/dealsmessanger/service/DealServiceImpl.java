package com.dealsmessanger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealsmessanger.model.Deal;
import com.dealsmessanger.repository.DealRepository;

@Service
public class DealServiceImpl implements DealsService {

	@Autowired
	private DealRepository dealRepository;
	
	public List<Deal> getDeals() {
		return dealRepository.getAllDeals();
	}

	public Deal getDeal() {
		Deal deal = new Deal();
		deal.setRadius(1);
		
		return deal;
	}
	
	public Deal saveDeal(Deal deal) {
		return dealRepository.saveDeal(deal);
	}

	public void deleteAllDeals() {
		dealRepository.deleteAllDeals();
	}

}
