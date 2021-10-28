package com.example.fooddelivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddelivery.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer>{

}
