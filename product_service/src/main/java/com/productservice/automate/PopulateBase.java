package com.productservice.automate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.productservice.model.Product;
import com.productservice.service.ProductRespository;


@Component
public class PopulateBase implements ApplicationListener<ContextRefreshedEvent> {
	private ProductRespository productRepository;

	@Autowired
	public PopulateBase(ProductRespository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		initData(9);
	}

	private void initData(int count) {

		for (int i = 1; i < count; i++) {
			Product product = new Product();
			String name = "name" + i;
			int quantity = i;
			long price = i * 100;

			//Category category = categoryRepository.findById(i).get();

			product.setName(name);
			product.setPrice(price);
			product.setQuantity(quantity);
			product.setCategoryId(i);
			
			productRepository.save(product);
		}

	}
}
