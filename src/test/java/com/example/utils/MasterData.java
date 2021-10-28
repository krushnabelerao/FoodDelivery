package com.example.utils;

import java.io.IOException;
import java.util.Date;

import com.example.fooddelivery.dto.BannerDto;
import com.example.fooddelivery.dto.CategoryDto;
import com.example.fooddelivery.dto.CustomerDto;
import com.example.fooddelivery.dto.MenuDto;
import com.example.fooddelivery.dto.OrderDto;
import com.example.fooddelivery.dto.RestaurantDto;
import com.example.fooddelivery.entity.Banner;
import com.example.fooddelivery.entity.Category;
import com.example.fooddelivery.entity.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MasterData {
	
	public static Banner getBanner() {
		Banner banner = new Banner();
		banner.setBannerId(1);
		banner.setName("ABCD");
		banner.setType("long");
		banner.setAllText("BBBBBBBBBBBBBBBBBB");
		banner.setHeight(1.1);
		banner.setImage("banner1");
		banner.setWidth(2.2);
		banner.setDescription("BBBBBBBBBBBBBBBBB");
		return banner;
	}
	
	public static BannerDto getBannerDto() {
		BannerDto bannerDto = new BannerDto();
		bannerDto.setBannerId(1);
		bannerDto.setName("ABCD");
		bannerDto.setType("long");
		bannerDto.setAllText("BBBBBBBBBBBBBBBBBB");
		bannerDto.setHeight(1.1);
		bannerDto.setImage("banner1");
		bannerDto.setWidth(2.2);
		bannerDto.setDescription("BBBBBBBBBBBBBBBBB");
		return bannerDto;
	}
	
	public static Category getcaCategory()
	{
		Category category = new Category();
		category.setCategoryId(1);
		category.setName("Masala");
		category.setTypeOfCat("veg");
		return category;
	}
	
	public static CategoryDto getCategoryDto()
	{
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setCategoryId(1);
		categoryDto.setName("Masala");
		categoryDto.setTypeOfCat("veg");
		return categoryDto;
	}
	
	public static CustomerDto getCustomerDto()
	{
		CustomerDto customerDto = new CustomerDto();
		customerDto.setCustomerId(1);
		customerDto.setName("krushna");
		customerDto.setPhoneNumber("1234567890");
		customerDto.setEmail("krushna@gmail.com");
		customerDto.setPassword("krushna@123");
		return customerDto;
	}
	
	public static Customer getCustomer()
	{
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setName("krushna");
		customer.setPhoneNumber("1234567890");
		customer.setEmail("krushna@gmail.com");
		customer.setPassword("krushna@123");
		return customer;
	}
	
	public static MenuDto getMenuDto() {
		MenuDto menuDto = new MenuDto();
		menuDto.setMenuId(1);
		menuDto.setTitle("Panner Masala");
		menuDto.setMenuType("Veg");
		menuDto.setDescription("Quite Spicy");
		return menuDto;
	}
	
	public static OrderDto getOrderDto(){
		OrderDto orderDto = new OrderDto();
		orderDto.setOrderId(1);
		orderDto.setName("Order1");
		orderDto.setResAddress("Hadapsar, Pune");
		orderDto.setResPhoneNo("123456466");
		orderDto.setOrderStatus("Places Success");
		orderDto.setOrderTime(new Date());
		return orderDto;
	}
	
	public static RestaurantDto getRestaurantDto() {
		RestaurantDto restaurantDto = new RestaurantDto();
		restaurantDto.setRestaurantId(1);
		restaurantDto.setResLogo("/reslogo");
		restaurantDto.setName("logo1");
		restaurantDto.setAddress("Kharadi");
		restaurantDto.setPhoneNumber("20202020");
		restaurantDto.setPassword("res1@123");
		return restaurantDto;
	}
	public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	public static byte[] toJson(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
}
