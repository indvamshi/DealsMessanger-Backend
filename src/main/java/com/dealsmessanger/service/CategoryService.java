package com.dealsmessanger.service;

import com.dealsmessanger.model.Category;

public interface CategoryService {

	Category saveCategory(Category ctg);

	Category getCategoryByName(String cName);

	void removeCategoryByName(String cName);
	
	void removeCategoryById(String id);
}
