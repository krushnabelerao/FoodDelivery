package com.example.fooddelivery.services;

import java.util.List;

import com.example.fooddelivery.dto.CategoryDto;

public interface CategoryService {
	public CategoryDto saveCategory(CategoryDto categoryDto);

    public List<CategoryDto> getAllCategories(); 

    public CategoryDto deleteCategory(int id);
    
    public CategoryDto updateCategory(CategoryDto category);
}
