package com.example.fooddelivery.services;

import java.util.List;

import com.example.fooddelivery.dto.OrderDto;

public interface OrderService {
	public OrderDto saveOrder(OrderDto orderDto);

    public List<OrderDto> getAllOrders(); 

    public OrderDto deleteOrder(int id);
    
    public OrderDto updateOrder(OrderDto orderDto);
}
