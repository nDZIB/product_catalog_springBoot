package com.productservice.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.productservice.service.Category;

@FeignClient(name="category-service",url = "localhost:8080")
public interface CategoryFeignProxy {
	
	@GetMapping("/api/category/{categoryid}")
	public ResponseEntity<Category> getSingleCategory(@PathVariable("categoryid") long categoryid);
}
