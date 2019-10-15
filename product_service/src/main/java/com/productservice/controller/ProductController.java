package com.productservice.controller;

import java.util.List;

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

import com.productservice.model.Product;
import com.productservice.service.ProductDTO;
import com.productservice.service.ProductServiceImpl;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private ProductServiceImpl service;
	
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
	
	@PostMapping("/category/{categoryid}")
	public ResponseEntity<ProductDTO> addNewProduct(@PathVariable("categoryid") long categoryid, 
			@RequestBody Product product) {
		
		return new ResponseEntity<ProductDTO>(service.saveProduct(product, categoryid), HttpStatus.CREATED);
	}
	
	@PutMapping("/{productid}/category/{categoryid}")
	public ResponseEntity<ProductDTO> modifyExistingProduct(@PathVariable("productid") long productid,
			@PathVariable("categoryid") long categoryid, @RequestBody Product product) {
	
		return new ResponseEntity<ProductDTO>(service.modifyProduct(product, productid, categoryid), HttpStatus.CREATED);
	}
}
