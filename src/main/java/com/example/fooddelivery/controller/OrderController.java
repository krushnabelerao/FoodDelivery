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

import com.example.fooddelivery.dto.OrderDto;
import com.example.fooddelivery.services.OrderService;
@RestController
@RequestMapping("/orderervice")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/add")
	public OrderDto saveOrder(@Valid @RequestBody OrderDto orderDto) {
        return orderService.saveOrder(orderDto);
    }

	@GetMapping("/getall")
    public List<OrderDto> getAllOrders() {
        return orderService.getAllOrders();
    }

	@DeleteMapping("/delete/{id}")
    public OrderDto deleteOrder(@PathVariable(value = "id") int id) {
        return orderService.deleteOrder(id);
    }
	
	@PutMapping("/update")
	public OrderDto updateOrder(@Valid @RequestBody OrderDto orderDto){
		return orderService.updateOrder(orderDto);
	}
}
