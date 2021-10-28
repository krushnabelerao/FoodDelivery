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

import com.example.fooddelivery.controller.CustomerController;
import com.example.fooddelivery.dto.CustomerDto;
import com.example.fooddelivery.services.CustomerService;
@Order(2)
@WebMvcTest(CustomerController.class)
@AutoConfigureMockMvc
public class TestCustomerException {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;
	
	@Test
	public void testCustomerExceptionDataValidationCheckIsAddedInController() throws Exception {
		CustomerDto customerDto = com.example.utils.MasterData.getCustomerDto();
		ExceptionResponse exResponse = new ExceptionResponse(
				"Data Not Added", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(customerService.saveCustomer(customerDto))
				.thenThrow(new CommonException("Data Not Added"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/customerservice/add")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), (result.getResponse().getStatus() == 400 && exResponse != null) ? true : false, exceptionTestFile);

	}
	
	@Test
	void testCustomerExceptionIsThrownAndHandledIfAdminNotAvailableWhileGettingAllCustomers() throws Exception {
		ExceptionResponse exResponse = new ExceptionResponse(
				"Data Not Found", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(customerService.getAllCustomers())
				.thenThrow(new CommonException("Data Not Found"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customerservice/getall")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == 400 && exResponse!=null ? true : false),
				exceptionTestFile);

	}

	@Test
	void testCustomerExceptionIsThrownAndHandledIfCustomerIdIsNotValidWhileDeleting() throws Exception {

		CustomerDto customerDto = com.example.utils.MasterData.getCustomerDto();
		Integer id = customerDto.getCustomerId();

		ExceptionResponse exResponse = new ExceptionResponse(
				"Customer with Id - " + id + " not found!", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(this.customerService.deleteCustomer(id))
				.thenThrow(new CommonException("Customer with Id - " + id + " not found!"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/customerservice/delete/" + id)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == 400 && exResponse!=null) ? true : false,
				exceptionTestFile);
	}
	
	@Test
	void testCustomerExceptionIsThrownAndHandledIfCustomerWhileUpdating() throws Exception {

		CustomerDto customerDto = com.example.utils.MasterData.getCustomerDto();

		ExceptionResponse exResponse = new ExceptionResponse(
				"Customer not get Updated", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(this.customerService.updateCustomer(customerDto))
				.thenThrow(new CommonException("Customer not get Updated"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/customerservice/update")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == 400 && exResponse!=null) ? true : false,
				exceptionTestFile);
	}
}
