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

import com.example.fooddelivery.controller.OrderController;
import com.example.fooddelivery.dto.OrderDto;
import com.example.fooddelivery.services.OrderService;
@Order(2)
@WebMvcTest(OrderController.class)
@AutoConfigureMockMvc
public class TestOrderException {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OrderService orderService;
	
	@Test
	public void testOrderExceptionDataValidationCheckIsAddedInController() throws Exception {
		OrderDto orderDto = com.example.utils.MasterData.getOrderDto();
		ExceptionResponse exResponse = new ExceptionResponse(
				"Data Not Added", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(orderService.saveOrder(orderDto))
				.thenThrow(new CommonException("Data Not Added"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/orderservice/add")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), (result.getResponse().getStatus() == 404 && exResponse != null) ? true : false, exceptionTestFile);

	}
	
	@Test
	void testOrderExceptionIsThrownAndHandledIfAdminNotAvailableWhileGettingAllOrders() throws Exception {
		ExceptionResponse exResponse = new ExceptionResponse(
				"Data Not Found", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(orderService.getAllOrders())
				.thenThrow(new CommonException("Data Not Found"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/orderservice/getall")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == 404 && exResponse!=null ? true : false),
				exceptionTestFile);

	}

	@Test
	void testOrderExceptionIsThrownAndHandledIfOrderIdIsNotValidWhileDeleting() throws Exception {

		OrderDto orderDto = com.example.utils.MasterData.getOrderDto();
		Integer id = orderDto.getOrderId();

		ExceptionResponse exResponse = new ExceptionResponse(
				"Order with Id - " + id + " not found!", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(this.orderService.deleteOrder(id))
				.thenThrow(new CommonException("Order with Id - " + id + " not found!"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/orderservice/delete/" + id)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == 404 && exResponse!=null) ? true : false,
				exceptionTestFile);
	}
	
	@Test
	void testOrderExceptionIsThrownAndHandledIfOrderWhileUpdating() throws Exception {

		OrderDto orderDto = com.example.utils.MasterData.getOrderDto();

		ExceptionResponse exResponse = new ExceptionResponse(
				"Order not get Updated", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(this.orderService.updateOrder(orderDto))
				.thenThrow(new CommonException("Order not get Updated"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/orderservice/update")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == 404 && exResponse!=null) ? true : false,
				exceptionTestFile);
	}
}
