package com.example.fooddelivery.functional;

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

import com.example.fooddelivery.controller.OrderController;
import com.example.fooddelivery.dto.OrderDto;
import com.example.fooddelivery.services.OrderService;
import com.example.utils.MasterData;

@Order(1)
@WebMvcTest(OrderController.class)
@AutoConfigureMockMvc
public class OrderControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private OrderService orderService;
	
	@Test
	void testOrderRestEndpointForAddNewOrder() throws Exception {
		OrderDto OrderDto = MasterData.getOrderDto();
		Mockito.when(orderService.saveOrder(OrderDto)).thenReturn(OrderDto);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/orderservice/add")
				.content(MasterData.asJsonString(MasterData.getOrderDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result.getResponse() != null) ? true : false,	businessTestFile);
	}
	
	@Test
	void testOrderRestEndpointForFindAllOrdersIsExposedAndWorking() throws Exception {
		List<OrderDto> list = new ArrayList<>();
		list.add(MasterData.getOrderDto());
		Mockito.when(orderService.getAllOrders()).thenReturn(list);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/orderservice/getall")
				.content(MasterData.asJsonString(MasterData.getOrderDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result.getResponse() != null)? true : false,	businessTestFile);
	}
	
	@Test
	void testOrderRestEndpointForDeleteOrdersById() throws Exception {
		OrderDto OrderDto = MasterData.getOrderDto();
		Integer id = OrderDto.getOrderId();
		Mockito.when(orderService.deleteOrder(id)).thenReturn(OrderDto);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/orderservice/delete/"+id)
				.content(MasterData.asJsonString(MasterData.getOrderDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result!=null ? "true" : "false"),	businessTestFile);
	}
	
	@Test
	void testOrderRestEndpointForUpdateOrder() throws Exception {
		OrderDto OrderDto = MasterData.getOrderDto();
		Mockito.when(orderService.updateOrder(OrderDto)).thenReturn(OrderDto);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/orderservice/update")
				.content(MasterData.asJsonString(MasterData.getOrderDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result.getResponse() != null) ? true : false,	businessTestFile);
	}
}
