package com.productservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.productservice.model.Product;

@Service
public class ProductServiceImpl  implements ProductService{

	private ProductRespository productRepository;
	
	public ProductServiceImpl(ProductRespository productRepository) {
		this.productRepository = productRepository;
	}
	
	
	@Override
	public List<ProductDTO> getAllProducts() {
		
		List<ProductDTO> rawList = new ArrayList<ProductDTO>();
		productRepository.findAll()
				.forEach(product -> rawList.add(product.toDTO()));
		
		return rawList;
	}


	public ProductDTO getProductWithId(long productid) {
		return productRepository.findById(productid).get().toDTO();
	}


	public void deleteProductById(long productid) {
		
		productRepository.deleteById(productid);
	}


	public ProductDTO saveProduct(Product product, long categoryid) {
		
		//verify that the specified category exists by calling the category api
		//if exists, set the category id for the product
		product.setCategoryId(categoryid);
		
		//if category is not found, exception is thrown from category service
		return productRepository.save(product).toDTO();
	}


	public ProductDTO modifyProduct(Product product, long productid, long categoryid) {
		
		if(productRepository.existsById(productid)) {
			//verify that the category as well exists
				//then save the product
			product.setId(productid);
			product.setCategoryId(categoryid);
			
			return productRepository.save(product).toDTO();
		}
		//if not found, throw exception
		return null;
	}

}
