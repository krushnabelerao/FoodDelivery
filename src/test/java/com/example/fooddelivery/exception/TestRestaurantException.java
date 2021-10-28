package com.example.fooddelivery.exception;

import static com.example.utils.TestUtils.currentTest;
import static com.example.utils.TestUtils.exceptionTestFile;
import static com.example.utils.TestUtils.yakshaAssert;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.fooddelivery.controller.RestaurantController;
import com.example.fooddelivery.dto.RestaurantDto;
import com.example.fooddelivery.services.RestaurantService;
@Order(2)
@WebMvcTest(RestaurantController.class)
@AutoConfigureMockMvc
public class TestRestaurantException {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RestaurantService restaurantService;
	
	@Test
	public void testRestaurantExceptionDataValidationCheckIsAddedInController() throws Exception {
		RestaurantDto restaurantDto = com.example.utils.MasterData.getRestaurantDto();
		ExceptionResponse exResponse = new ExceptionResponse(
				"Data Not Added", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(restaurantService.saveRestaurant(restaurantDto))
				.thenThrow(new CommonException("Data Not Added"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/restaurantservice/add")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), (result.getResponse().getStatus() == 400 && exResponse != null) ? true : false, exceptionTestFile);

	}
	
	@Test
	void testRestaurantExceptionIsThrownAndHandledIfAdminNotAvailableWhileGettingAllRestaurants() throws Exception {
		ExceptionResponse exResponse = new ExceptionResponse(
				"Data Not Found", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(restaurantService.getAllRestaurants())
				.thenThrow(new CommonException("Data Not Found"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/restaurantservice/getall")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == 400 && exResponse!=null ? true : false),
				exceptionTestFile);

	}

	@Test
	void testRestaurantExceptionIsThrownAndHandledIfRestaurantIdIsNotValidWhileDeleting() throws Exception {

		RestaurantDto restaurantDto = com.example.utils.MasterData.getRestaurantDto();
		Integer id = restaurantDto.getRestaurantId();

		ExceptionResponse exResponse = new ExceptionResponse(
				"Restaurant with Id - " + id + " not found!", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(this.restaurantService.deleteRestaurant(id))
				.thenThrow(new CommonException("Restaurant with Id - " + id + " not found!"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/restaurantservice/delete/" + id)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == 400 && exResponse!=null) ? true : false,
				exceptionTestFile);
	}
	
	@Test
	void testRestaurantExceptionIsThrownAndHandledIfRestaurantWhileUpdating() throws Exception {

		RestaurantDto restaurantDto = com.example.utils.MasterData.getRestaurantDto();

		ExceptionResponse exResponse = new ExceptionResponse(
				"Restaurant not get Updated", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(this.restaurantService.updateRestaurant(restaurantDto))
				.thenThrow(new CommonException("Restaurant not get Updated"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/restaurantservice/update")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == 400 && exResponse!=null) ? true : false,
				exceptionTestFile);
	}
}
