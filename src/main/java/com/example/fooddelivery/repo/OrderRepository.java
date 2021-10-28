package com.example.fooddelivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddelivery.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
