package com.productservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.productservice.service.ProductDTO;

@Entity
public class Product {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	private String name;
	private long price;
	private int quantity;
	private long categoryId;
	
	
	
	public Product(long id, String name, long price, int quantity) {
		this.id = id;
		this.setName(name);
		this.price = price;
		this.quantity = quantity;
	}
	
	public Product(long id, String name, long price, int quantity, long categoryId) {
		this.id = id;
		this.setName(name);
		this.price = price;
		this.quantity = quantity;
		this.categoryId = categoryId;
	}
	
	public Product() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductDTO toDTO() {
		return new ProductDTO(getId(),getName(), getPrice(), getQuantity());
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
}
