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

import com.example.fooddelivery.dto.CustomerDto;
import com.example.fooddelivery.services.CustomerService;
@RestController
@RequestMapping("/customerservice")
public class CustomerController {
	
		@Autowired
		private CustomerService customerService;
		
		@PostMapping("/add")
		public CustomerDto saveCustomer(@Valid @RequestBody CustomerDto customerDto) {
	        return customerService.saveCustomer(customerDto);
	    }

		@GetMapping("/getall")
	    public List<CustomerDto> getAllCustomers() {
	        return customerService.getAllCustomers();
	    }

		@DeleteMapping("/delete/{id}")
	    public CustomerDto deleteCustomer(@PathVariable(value = "id") int id) {
	        return customerService.deleteCustomer(id);
	    }
		
		@PutMapping("/update")
		public CustomerDto updateCustomer(@Valid @RequestBody CustomerDto customerDto){
			return customerService.updateCustomer(customerDto);
		}
}
