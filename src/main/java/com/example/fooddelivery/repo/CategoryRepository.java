package com.example.fooddelivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddelivery.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
