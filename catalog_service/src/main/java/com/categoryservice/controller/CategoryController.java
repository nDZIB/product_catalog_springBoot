package com.categoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.categoryservice.model.Category;
import com.categoryservice.service.CategoryDTO;
import com.categoryservice.service.CategoryServiceImpl;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	private CategoryServiceImpl service;
	
	@Autowired
	public CategoryController(CategoryServiceImpl service) {
	
		this.service = service;
	}

	@GetMapping("/")
	public ResponseEntity<List<CategoryDTO>> getCategories() {
		
		return new ResponseEntity<List<CategoryDTO>>(service.getAllProducts(), HttpStatus.OK);
	}
	
	@GetMapping("/{categoryid}")
	public ResponseEntity<CategoryDTO> getSingleCategory(@PathVariable("categoryid") long categoryid) {
		
		return new ResponseEntity<CategoryDTO>(service.getSingleCategory(categoryid), HttpStatus.OK);
	}
	
	@DeleteMapping("/{categoryid}") 
	public ResponseEntity<Object> deleteProductWithId(@PathVariable("categoryid") long categoryid) {
		
		service.deleteCategoryWithId(categoryid);
		
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/")
	public ResponseEntity<CategoryDTO> addNewProduct(@RequestBody Category category) {
		
		return new ResponseEntity<CategoryDTO>(service.addCategory(category), HttpStatus.CREATED);
	}
	
	@PutMapping("/{categoryid}")
	public ResponseEntity<CategoryDTO> modifyExistingCategory(@RequestBody Category category, 
			@PathVariable("categoryid") long categoryid) {
		
		return new ResponseEntity<CategoryDTO>(service.modifyCategoryWithId(category, categoryid), HttpStatus.CREATED);
	}
}
