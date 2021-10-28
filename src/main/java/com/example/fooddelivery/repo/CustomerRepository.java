package com.example.fooddelivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fooddelivery.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
