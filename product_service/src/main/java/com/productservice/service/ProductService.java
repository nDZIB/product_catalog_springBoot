package com.productservice.service;

import java.util.List;

import com.productservice.model.Product;

public interface ProductService {

	List<ProductDTO> getAllProducts();

	ProductDTO createNewProduct(Product product, long categoryid);

	ProductDTO getProductWithId(long productid);

	void deleteProductById(long productid);

	ProductDTO saveProduct(Product product, long categoryid);

	ProductDTO modifyProduct(Product product, long productid, long categoryid);

}
