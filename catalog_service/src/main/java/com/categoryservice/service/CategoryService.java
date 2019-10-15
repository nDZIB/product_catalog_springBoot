package com.categoryservice.service;

import java.util.List;

import com.categoryservice.model.Category;

public interface CategoryService {

	List<CategoryDTO> getAllProducts();

	CategoryDTO getSingleCategory(long categoryid);

	void deleteCategoryWithId(long categoryid);

	CategoryDTO addCategory(Category category);

	CategoryDTO modifyCategoryWithId(Category category, long categoryid);

}
