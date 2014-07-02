package com.dealsmessanger.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.dealsmessanger.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Category saveCategory(Category ctg) {
		if (ctg.getCategoryId() == null) {
			ctg.setCategoryId(UUID.randomUUID().toString());
		}
		mongoTemplate.save(ctg);
		
		return ctg;
	}

	public Category getCategoryByName(String ctgName) {
		List<Category> ctgList = mongoTemplate.find(new Query(Criteria.where("ctgName").
				is(ctgName)), Category.class);
		
		return ctgList != null && ctgList.size() > 0 ? ctgList.get(0) : null;
	}

}
