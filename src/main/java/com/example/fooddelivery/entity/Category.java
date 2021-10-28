package com.example.fooddelivery.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer categoryId;
	private String name;
	private String typeOfCat;
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String categoryName) {
		this.name = categoryName;
	}
	public String getTypeOfCat() {
		return typeOfCat;
	}
	public void setTypeOfCat(String typeOfCat) {
		this.typeOfCat = typeOfCat;
	}

	
}
