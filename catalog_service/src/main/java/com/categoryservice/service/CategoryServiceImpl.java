package com.categoryservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.categoryservice.model.Category;
import com.categoryservice.model.repository.CategoryRepository;
import com.categoryservice.service.proxy.ProductServiceProxy;

@Service
public class CategoryServiceImpl implements CategoryService{

	private CategoryRepository categoryRepository;
	private ProductServiceProxy productProxy;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository, ProductServiceProxy productProxy) {
		this.categoryRepository = categoryRepository;
		this.productProxy = productProxy;
	}
	
	@Override
	public List<CategoryDTO> getAllProducts() {
		
		List<CategoryDTO> categories = new ArrayList<CategoryDTO>();
		
		categoryRepository.findAll().forEach(category -> categories.add(category.toDTO()));
		
		return categories;
	}

	@Override
	public CategoryDTO getSingleCategory(long categoryid) {
		return categoryRepository.findById(categoryid).get().toDTO();
	}

	@Override
	public void deleteCategoryWithId(long categoryid) {
		
		if(categoryRepository.existsById(categoryid)) {
			productProxy.deleteCategoryProduct(categoryid);
			//then delete category
		}
		//otherwise throw exception
		
		categoryRepository.deleteById(categoryid);
	}

	@Override
	public CategoryDTO addCategory(Category category) {
		return categoryRepository.save(category).toDTO();
	}

	@Override
	public CategoryDTO modifyCategoryWithId(Category category, long categoryid) {
		
		if (categoryRepository.existsById(categoryid)) {
			category.setId(categoryid);
			
			return categoryRepository.save(category).toDTO();
		}
		
		//if category does not exist
			//throw an exception
		return categoryRepository.save(category).toDTO();
	}
	
	

}
