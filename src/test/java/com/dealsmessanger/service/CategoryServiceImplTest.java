package com.dealsmessanger.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dealsmessanger.model.Category;
import com.dealsmessanger.util.TestInMemoryMongo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/repository-context-test.xml" })
public class CategoryServiceImplTest extends TestInMemoryMongo {

	@Autowired
	private CategoryService categoryService;
	
	@Test
	public void shouldSaveAndReturnCategory() {
		Category ctg = new Category();
		ctg.setCtgName("ctg1");
		categoryService.saveCategory(ctg);

		Assert.assertNotNull(categoryService.getCategoryByName("ctg1"));
	}
	
	
}
