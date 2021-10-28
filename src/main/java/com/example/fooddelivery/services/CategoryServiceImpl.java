package com.example.fooddelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fooddelivery.dto.CategoryDto;
import com.example.fooddelivery.entity.Category;
import com.example.fooddelivery.repo.CategoryRepository;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public CategoryDto saveCategory(CategoryDto categoryDto) {
		Category category = new Category();
		category.setCategoryId(categoryDto.getCategoryId());
		category.setName(categoryDto.getName());
		category.setTypeOfCat(categoryDto.getTypeOfCat());
		categoryRepository.save(category);
         return categoryDto; 
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> categories = categoryRepository.findAll();

		return categories.stream()
				.map(categoryDto -> new CategoryDto(categoryDto.getCategoryId(),categoryDto.getName(),categoryDto.getTypeOfCat()))
				.collect(Collectors.toList());
	}

	@Override
	public CategoryDto deleteCategory(int id) {
		Category category = categoryRepository.findById(id).orElse(null);
		CategoryDto categoryDto = new CategoryDto();
		if (category != null) {
			categoryDto.setCategoryId(category.getCategoryId());
			categoryDto.setName(category.getName());
			categoryDto.setTypeOfCat(category.getTypeOfCat());
			categoryRepository.save(category);
		}
		categoryRepository.deleteById(id);
		return categoryDto;
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto) {
		Category existingCategory = categoryRepository.findById(categoryDto.getCategoryId()).orElse(null);
		existingCategory.setName(categoryDto.getName());
		existingCategory.setTypeOfCat(categoryDto.getTypeOfCat());
        categoryRepository.save(existingCategory);
        return categoryDto;
	}


}
