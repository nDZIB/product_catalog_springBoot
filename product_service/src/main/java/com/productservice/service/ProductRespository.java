package com.productservice.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productservice.model.Product;

public interface ProductRespository extends JpaRepository<Product, Long>{

}
