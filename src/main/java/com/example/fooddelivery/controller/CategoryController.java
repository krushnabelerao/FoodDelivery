package com.example.fooddelivery.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fooddelivery.dto.CategoryDto;
import com.example.fooddelivery.services.CategoryService;
@RestController
@RequestMapping("/categoryservice")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/add")
	public CategoryDto saveCategory(@Valid @RequestBody CategoryDto categoryDto) {
        return categoryService.saveCategory(categoryDto);
    }

	@GetMapping("/getall")
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

	@DeleteMapping("/delete/{id}")
    public CategoryDto deleteCategory(@PathVariable(value = "id") int id) {
        return categoryService.deleteCategory(id);
    }
	
	@PutMapping("/update")
    public CategoryDto updateCategory(@Valid @RequestBody CategoryDto categoryDto) {
        return categoryService.updateCategory(categoryDto);
    }
}
