package com.productservice.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productservice.model.Product;

public interface ProductRespository extends JpaRepository<Product, Long>{

	List<Product> findByCategoryId(long categoryid);
}
