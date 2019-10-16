package com.categoryservice.service.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service", url = "localhost:8081")
public interface ProductServiceProxy {

	@DeleteMapping("/api/products/categories/{categoryid}") 
	public void deleteCategoryProduct(@PathVariable("categoryid") long categoryid);
}
