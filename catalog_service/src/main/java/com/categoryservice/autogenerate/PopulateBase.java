package com.categoryservice.autogenerate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.categoryservice.model.Category;
import com.categoryservice.model.repository.CategoryRepository;


@Component
public class PopulateBase implements ApplicationListener<ContextRefreshedEvent> {
	private CategoryRepository categoryRepository;
	
	@Autowired
	public PopulateBase(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	@Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData(10);
    }

    private void initData(int count) {
       for(int i = 0; i < count; i++){
    	   String name = "category" + i;
            Category category = new Category();
            category.setName(name);
            
             categoryRepository.save(category);
            
       }   
    }



}
