package com.dealsmessanger.service;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.dealsmessanger.model.Business;
import com.dealsmessanger.model.Deal;

@Service
public class BusinessServiceImpl implements BusinessService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public Business saveBusiness(Business business) {
		if (business.getBusinessId() == null) {
			business.setBusinessId(UUID.randomUUID().toString());
			business.setCreatedTime(Calendar.getInstance().getTime());
		}
		business.setUpdatedTime(Calendar.getInstance().getTime());
	
		mongoTemplate.save(business);
		
		return business;
	}

	@Override
	public Business getBusinessById(String id) {
		return mongoTemplate.findById(id, Business.class);
	}

	@Override
	public List<Business> getAllBusiness() {
		return mongoTemplate.findAll(Business.class);
	}

	@Override
	public List<Deal> getAllDeals(String businessName) {
		Business business = getBusinessByName(businessName);

		return business != null ? business.getDeal() : null;
	}

	@Override
	public Business getBusinessByName(String businessName) {
		List<Business> businessList = mongoTemplate.find(new Query(Criteria.where("name").
				is(businessName)), Business.class);

		return businessList != null && businessList.size() == 1 ? businessList.get(0) : null;
	}

	@Override
	public void removeBusiness(String id) {
		List<Business> businessList = mongoTemplate.find(new Query(Criteria.where("businessId").
				is(id)), Business.class);
		
		if (businessList != null && businessList.size() == 1) {
			Business business = businessList.get(0);
			mongoTemplate.remove(business.getDeal());
			mongoTemplate.remove(business);
		}
	}

	@Override
	public void removeAll() {
		
	}
}
