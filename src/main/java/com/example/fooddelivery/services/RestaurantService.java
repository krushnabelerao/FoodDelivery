package com.example.fooddelivery.services;

import java.util.List;

import com.example.fooddelivery.dto.RestaurantDto;

public interface RestaurantService {
	public RestaurantDto saveRestaurant(RestaurantDto restaurantDto);

    public List<RestaurantDto> getAllRestaurants(); 

    public RestaurantDto deleteRestaurant(int id);
    
    public RestaurantDto updateRestaurant(RestaurantDto restaurantDto);
}
