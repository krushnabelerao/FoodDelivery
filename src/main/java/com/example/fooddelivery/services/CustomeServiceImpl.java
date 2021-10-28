package com.example.fooddelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fooddelivery.dto.CustomerDto;
import com.example.fooddelivery.entity.Customer;
import com.example.fooddelivery.repo.CustomerRepository;
@Service
@Transactional
public class CustomeServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public CustomerDto saveCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setCustomerId(customerDto.getCustomerId());
		customer.setName(customerDto.getName());
		customer.setPhoneNumber(customerDto.getPhoneNumber());
		customer.setEmail(customerDto.getEmail());
		customer.setPassword(customerDto.getPassword());
		customerRepository.save(customer);
         return customerDto; 
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();

		return customers.stream()
				.map(customerDto -> new CustomerDto(customerDto.getCustomerId(),customerDto.getName(),customerDto.getEmail(),
						customerDto.getPhoneNumber(),customerDto.getPassword()))
				.collect(Collectors.toList());
	}

	@Override
	public CustomerDto deleteCustomer(int id) {
		Customer customer = customerRepository.findById(id).orElse(null);
		CustomerDto customerDto = new CustomerDto();
		if (customer != null) {
			customerDto.setCustomerId(customer.getCustomerId());
			customerDto.setName(customer.getName());
			customerDto.setPhoneNumber(customer.getPhoneNumber());
			customerDto.setEmail(customer.getEmail());
			customerDto.setPassword(customer.getPassword());
			customerRepository.save(customer);
		}
		customerRepository.deleteById(id);
		return customerDto;
	}

	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto) {
		Customer existingCustomer = customerRepository.findById(customerDto.getCustomerId()).orElse(null);
		existingCustomer.setName(customerDto.getName());
		existingCustomer.setPhoneNumber(customerDto.getPhoneNumber());
		existingCustomer.setEmail(customerDto.getEmail());
		existingCustomer.setPassword(customerDto.getPassword());
		customerRepository.save(existingCustomer);
         return customerDto; 
	}

}
