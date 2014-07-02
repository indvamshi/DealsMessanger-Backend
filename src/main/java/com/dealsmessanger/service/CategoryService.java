package com.dealsmessanger.service;

import com.dealsmessanger.model.Category;

public interface CategoryService {

	Category saveCategory(Category ctg);

	Category getCategoryByName(String string);
}
