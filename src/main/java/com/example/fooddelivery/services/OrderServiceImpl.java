package com.example.fooddelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fooddelivery.dto.OrderDto;
import com.example.fooddelivery.entity.Order;
import com.example.fooddelivery.repo.OrderRepository;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Override
	public OrderDto saveOrder(OrderDto orderDto) {
		Order order = new Order();
		order.setOrderId(orderDto.getOrderId());
		order.setName(orderDto.getName());
		order.setResAddress(orderDto.getResAddress());
		order.setResPhoneNo(orderDto.getResPhoneNo());
		order.setOrderStatus(orderDto.getOrderStatus());
		order.setOrderTime(orderDto.getOrderTime());
		order.setEstimationToDeliver(orderDto.getEstimationToDeliver());
		orderRepository.save(order);
         return orderDto; 
	}

	@Override
	public List<OrderDto> getAllOrders() {
		List<Order> orders = orderRepository.findAll();

		return orders.stream()
				.map(orderDto -> new OrderDto(orderDto.getOrderId(),orderDto.getName(),orderDto.getResAddress(),orderDto.getResPhoneNo(),
						orderDto.getOrderStatus(),orderDto.getOrderTime(),orderDto.getEstimationToDeliver()
						))
				.collect(Collectors.toList());
	}

	@Override
	public OrderDto deleteOrder(int id) {
		Order order = orderRepository.findById(id).orElse(null);
		OrderDto orderDto = new OrderDto();
		if (order != null) {
			orderDto.setOrderId(order.getOrderId());
			orderDto.setName(order.getName());
			orderDto.setResAddress(order.getResAddress());
			orderDto.setResPhoneNo(order.getResPhoneNo());
			orderDto.setOrderStatus(order.getOrderStatus());
			orderDto.setOrderTime(order.getOrderTime());
			orderDto.setEstimationToDeliver(order.getEstimationToDeliver());
		}
		orderRepository.deleteById(id);
		return orderDto;
	}

	@Override
	public OrderDto updateOrder(OrderDto orderDto) {
		Order existingMenu = orderRepository.findById(orderDto.getOrderId()).orElse(null);
		existingMenu.setName(orderDto.getName());
		existingMenu.setResAddress(orderDto.getResAddress());
		existingMenu.setResPhoneNo(orderDto.getResPhoneNo());
		existingMenu.setOrderStatus(orderDto.getOrderStatus());
		existingMenu.setOrderTime(orderDto.getOrderTime());
		existingMenu.setEstimationToDeliver(orderDto.getEstimationToDeliver());
		orderRepository.save(existingMenu);
		return orderDto;
	}


}
