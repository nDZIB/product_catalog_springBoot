package com.categoryservice.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.categoryservice.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
