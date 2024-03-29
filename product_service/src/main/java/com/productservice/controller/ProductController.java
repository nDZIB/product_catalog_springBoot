package com.productservice.controller;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.productservice.model.Product;
import com.productservice.proxy.CategoryFeignProxy;
import com.productservice.service.ProductDTO;
import com.productservice.service.ProductServiceImpl;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private ProductServiceImpl service;
	
	@Autowired
	public ProductController(ProductServiceImpl service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<ProductDTO>> getProducts() {
		
		return new ResponseEntity<List<ProductDTO>>(service.getAllProducts(), HttpStatus.OK);
	}
	
	@GetMapping("/{productid}")
	public ResponseEntity<ProductDTO> getSingleProduct(@PathVariable("productid") long productid) {
		
		return new ResponseEntity<ProductDTO>(service.getProductWithId(productid), HttpStatus.OK);
	}
	
	@DeleteMapping("/{productid}") 
	public void deleteSingleProduct(@PathVariable("productid") long productid) {
		service.deleteProductById(productid);
	}
	
	@DeleteMapping("/categories/{categoryid}") 
	public void deleteCategoryProduct(@PathVariable("categoryid") long categoryid) {
		service.deleteProductByCategoryId(categoryid);
	}
	
	@PutMapping("/{productid}/category/{categoryid}")
	public ResponseEntity<ProductDTO> modifyExistingProduct(@PathVariable("productid") long productid,
			@PathVariable("categoryid") long categoryid, @RequestBody Product product) {
	
		return new ResponseEntity<ProductDTO>(service.modifyProduct(product, productid, categoryid), HttpStatus.CREATED);
	}
	
	@PostMapping("/category/{categoryid}")
	public ResponseEntity<ProductDTO> addProduct(@PathVariable("categoryid") long categoryid, 
			@RequestBody Product product) {
		
		return new ResponseEntity<ProductDTO>(service.createNewProduct(product, categoryid), HttpStatus.CREATED);
	}
}
