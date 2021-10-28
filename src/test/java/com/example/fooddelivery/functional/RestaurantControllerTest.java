package com.example.fooddelivery.functional;

import static com.example.utils.TestUtils.asJsonString;
import static com.example.utils.TestUtils.businessTestFile;
import static com.example.utils.TestUtils.currentTest;
import static com.example.utils.TestUtils.yakshaAssert;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.fooddelivery.controller.RestaurantController;
import com.example.fooddelivery.dto.RestaurantDto;
import com.example.fooddelivery.services.RestaurantService;
import com.example.utils.MasterData;

@Order(1)
@WebMvcTest(RestaurantController.class)
@AutoConfigureMockMvc
public class RestaurantControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private RestaurantService restaurantService;
	
	@Test
	void testRestaurantRestEndpointForAddNewRestaurant() throws Exception {
		RestaurantDto RestaurantDto = MasterData.getRestaurantDto();
		Mockito.when(restaurantService.saveRestaurant(RestaurantDto)).thenReturn(RestaurantDto);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/restaurantservice/add")
				.content(MasterData.asJsonString(MasterData.getRestaurantDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result.getResponse() != null) ? true : false,	businessTestFile);
	}
	
	@Test
	void testRestaurantRestEndpointForFindAllRestaurantsIsExposedAndWorking() throws Exception {
		List<RestaurantDto> list = new ArrayList<>();
		list.add(MasterData.getRestaurantDto());
		Mockito.when(restaurantService.getAllRestaurants()).thenReturn(list);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/restaurantservice/getall")
				.content(MasterData.asJsonString(MasterData.getRestaurantDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result.getResponse().getContentAsString().contentEquals(asJsonString(list))? true : false),	businessTestFile);
	}
	
	@Test
	void testRestaurantRestEndpointForDeleteRestaurantsById() throws Exception {
		RestaurantDto RestaurantDto = MasterData.getRestaurantDto();
		Integer id = RestaurantDto.getRestaurantId();
		Mockito.when(restaurantService.deleteRestaurant(id)).thenReturn(RestaurantDto);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/restaurantservice/delete/"+id)
				.content(MasterData.asJsonString(MasterData.getRestaurantDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result!=null ? "true" : "false"),	businessTestFile);
	}
	
	@Test
	void testRestaurantRestEndpointForUpdateRestaurant() throws Exception {
		RestaurantDto RestaurantDto = MasterData.getRestaurantDto();
		Mockito.when(restaurantService.updateRestaurant(RestaurantDto)).thenReturn(RestaurantDto);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/restaurantservice/update")
				.content(MasterData.asJsonString(MasterData.getRestaurantDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result.getResponse() != null) ? true : false,	businessTestFile);
	}
}
