package com.productservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.productservice.model.Product;
import com.productservice.proxy.CategoryFeignProxy;

@Service
public class ProductServiceImpl  implements ProductService{

	private ProductRespository productRepository;
	private CategoryFeignProxy categoryProxy;
	
	public ProductServiceImpl(ProductRespository productRepository, CategoryFeignProxy categoryProxy) {
		this.productRepository = productRepository;
		this.categoryProxy = categoryProxy;
	}
	
	
	@Override
	public List<ProductDTO> getAllProducts() {
		
		List<ProductDTO> rawList = new ArrayList<ProductDTO>();
		productRepository.findAll()
				.forEach(product -> {
					ProductDTO result = product.toDTO();
					result.setCategory(categoryProxy.getSingleCategory(product.getCategoryId()).getBody());
					rawList.add(result);
				});
		return rawList;
	}


	@Override
	public ProductDTO getProductWithId(long productid) {
		Product product = productRepository.findById(productid).get();
		ProductDTO result = product.toDTO();
		
		result.setCategory(categoryProxy.getSingleCategory(product.getCategoryId()).getBody());
		
		return result;
	}


	@Override
	public void deleteProductById(long productid) {
		
		productRepository.deleteById(productid);
	}


	@Override
	public ProductDTO saveProduct(Product product, long categoryid) {
		
//		//verify that the specified category exists by calling the category api
//		//if exists, set the category id for the product
//		product.setCategoryId(categoryid);
//		
//		//if category is not found, exception is thrown from category service
//		return productRepository.save(product).toDTO();
		return null;
	}


	@Override
	public ProductDTO modifyProduct(Product product, long productid, long categoryid) {
		
		if(productRepository.existsById(productid)) {
			
			//verify that the category as well exists
			Category category = categoryProxy.getSingleCategory(categoryid).getBody();
			if(category == null) {
				//throw an exception
			}
				//then save the product if the category exists
			product.setId(productid);
			product.setCategoryId(category.getId());
			
			ProductDTO result = productRepository.save(product).toDTO();
			result.setCategory(category);
			return result;
		}
		//if not found, throw exception
		return null;
	}


	@Override
	public ProductDTO createNewProduct(Product product, long categoryid) {
	Category category = categoryProxy.getSingleCategory(categoryid).getBody();
		
		if (category == null) {
			//throw exception
		} 
		
		product.setCategoryId(category.getId());
		
		ProductDTO result = productRepository.save(product).toDTO();
		result.setCategory(category);
		return result;
	}


	@Override
	public void deleteProductByCategoryId(long categoryid) {
		List<Product> products = productRepository.findByCategoryId(categoryid);
		
		products.forEach(product -> {
			productRepository.deleteById(product.getId());
		});
	}

}
