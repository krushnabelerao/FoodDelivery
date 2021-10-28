package com.example.fooddelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fooddelivery.dto.RestaurantDto;
import com.example.fooddelivery.entity.Restaurant;
import com.example.fooddelivery.repo.RestaurantRepository;
@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	@Override
	public RestaurantDto saveRestaurant(RestaurantDto restaurantDto) {
		Restaurant restaurant = new Restaurant();
		restaurant.setRestaurantId(restaurantDto.getRestaurantId());
		restaurant.setResLogo(restaurantDto.getResLogo());
		restaurant.setName(restaurantDto.getName());
		restaurant.setAddress(restaurantDto.getAddress());
		restaurant.setPhoneNumber(restaurantDto.getPhoneNumber());
		restaurant.setPassword(restaurantDto.getPassword());
		restaurantRepository.save(restaurant);
         return restaurantDto;
         
	}

	@Override
	public List<RestaurantDto> getAllRestaurants() {
		List<Restaurant> restaurants = restaurantRepository.findAll();

		return restaurants.stream()
				.map(restaurantDto -> new RestaurantDto(restaurantDto.getRestaurantId(),restaurantDto.getResLogo(),restaurantDto.getName(),
						restaurantDto.getAddress(),restaurantDto.getPhoneNumber(),restaurantDto.getPassword()))
				.collect(Collectors.toList());
	}

	@Override
	public RestaurantDto deleteRestaurant(int id) {
		Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
		RestaurantDto restaurantDto = new RestaurantDto();
		if (restaurant != null) {
			restaurantDto.setRestaurantId(restaurant.getRestaurantId());
			restaurantDto.setResLogo(restaurant.getResLogo());
			restaurantDto.setName(restaurant.getName());
			restaurantDto.setAddress(restaurant.getAddress());
			restaurantDto.setPhoneNumber(restaurant.getPhoneNumber());
			restaurantDto.setPassword(restaurant.getPassword());
		}
		restaurantRepository.deleteById(id);
		return restaurantDto;
	}

	@Override
	public RestaurantDto updateRestaurant(RestaurantDto restaurantDto) {
		Restaurant existingRestaurant = restaurantRepository.findById(restaurantDto.getRestaurantId()).orElse(null);
		existingRestaurant.setResLogo(restaurantDto.getResLogo());
		existingRestaurant.setName(restaurantDto.getName());
		existingRestaurant.setAddress(restaurantDto.getAddress());
		existingRestaurant.setPhoneNumber(restaurantDto.getPhoneNumber());
		existingRestaurant.setPassword(restaurantDto.getPassword());
		restaurantRepository.save(existingRestaurant);
		return restaurantDto;
	}


}
