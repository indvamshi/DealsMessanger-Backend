package com.dealsmessanger.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.dealsmessanger.model.Deal;

@Repository
public class DealRepository {
	
    private static final Logger logger = LoggerFactory.getLogger(DealRepository.class);

	@Autowired
	private MongoTemplate mongoTemplate;
	
    /**
     * this will create a {@link Deal} collection if the collection does not already exists
     */
    public Deal saveDeal(Deal deal) {
    	logger.debug("saving deal");
    	mongoTemplate.save(deal, "deal");
    
    	return deal;
    }

	public List<Deal> getAllDeals() {
		logger.debug("getting all deals");
		return mongoTemplate.findAll(Deal.class);
	}

	public void deleteAllDeals() {
		logger.debug("deleting all deals from database");
		mongoTemplate.dropCollection(Deal.class);
	}
}
