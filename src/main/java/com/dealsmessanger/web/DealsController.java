package com.dealsmessanger.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dealsmessanger.model.Deal;
import com.dealsmessanger.service.DealsService;

@Controller
public class DealsController {
	
	@Autowired
	private DealsService dealsService;

    private static final Logger logger = LoggerFactory.getLogger(DealsController.class);

    @RequestMapping(value = "/deal", method = RequestMethod.DELETE)
    @ResponseStatus( HttpStatus.OK )
    public void deleteAllDeals() {
        logger.info("deleting all deals");
        dealsService.deleteAllDeals();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Deal saveDeal(@RequestBody Deal deal) {
    	logger.debug("radius .........."+deal.getRadius());
    	return dealsService.saveDeal(deal);
    }
    
    @RequestMapping(value = "/deals", method = RequestMethod.GET)
    public @ResponseBody List<Deal> getAllDeals() {
    	return dealsService.getDeals();
    }
    
}
