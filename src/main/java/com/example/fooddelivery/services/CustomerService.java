package com.example.fooddelivery.services;

import java.util.List;

import com.example.fooddelivery.dto.CustomerDto;

public interface CustomerService {
	public CustomerDto saveCustomer(CustomerDto customerDto);

    public List<CustomerDto> getAllCustomers(); 

    public CustomerDto deleteCustomer(int id);
    
    public CustomerDto updateCustomer(CustomerDto customerDto);
}
