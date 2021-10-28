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

import com.example.fooddelivery.dto.RestaurantDto;
import com.example.fooddelivery.services.RestaurantService;
@RestController
@RequestMapping("/restaurantservice")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/add")
	public RestaurantDto saveRestaurant(@Valid @RequestBody RestaurantDto restaurantDto) {
        return restaurantService.saveRestaurant(restaurantDto);
    }

	@GetMapping("/getall")
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

	@DeleteMapping("/delete/{id}")
    public RestaurantDto deleteRestaurant(@PathVariable(value = "id") int id) {
        return restaurantService.deleteRestaurant(id);
    }
	
	@PutMapping("/update")
	public RestaurantDto updateRestaurant(@Valid @RequestBody RestaurantDto restaurantDto){
		return restaurantService.updateRestaurant(restaurantDto);
	}
}
