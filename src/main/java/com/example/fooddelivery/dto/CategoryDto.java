package com.example.fooddelivery.dto;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

public class CategoryDto {
	@NotNull
	private Integer categoryId;
	@NotNull
	@Length(max = 20,min = 5)
	private String name;
	@NotNull
	@Length(max = 20,min = 5)
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
	public void setName(String name) {
		this.name = name;
	}
	public String getTypeOfCat() {
		return typeOfCat;
	}
	public void setTypeOfCat(String typeOfCat) {
		this.typeOfCat = typeOfCat;
	}
	
	
	public CategoryDto() {
		super();
	}
	public CategoryDto(Integer categoryId, String categoryName, String typeOfCat) {
		super();
		this.categoryId = categoryId;
		this.name = categoryName;
		this.typeOfCat = typeOfCat;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((typeOfCat == null) ? 0 : typeOfCat.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryDto other = (CategoryDto) obj;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (typeOfCat == null) {
			if (other.typeOfCat != null)
				return false;
		} else if (!typeOfCat.equals(other.typeOfCat))
			return false;
		return true;
	}

	
}
