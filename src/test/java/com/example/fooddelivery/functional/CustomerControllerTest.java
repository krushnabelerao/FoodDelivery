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

import com.example.fooddelivery.controller.CustomerController;
import com.example.fooddelivery.dto.CustomerDto;
import com.example.fooddelivery.services.CustomerService;
import com.example.utils.MasterData;

@Order(1)
@WebMvcTest(CustomerController.class)
@AutoConfigureMockMvc
public class CustomerControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private CustomerService customerService;
	
	@Test
	void testCustomerRestEndpointForAddNewCustomer() throws Exception {
		CustomerDto CustomerDto = MasterData.getCustomerDto();
		Mockito.when(customerService.saveCustomer(CustomerDto)).thenReturn(CustomerDto);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/customerservice/add")
				.content(MasterData.asJsonString(MasterData.getCustomerDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result.getResponse() != null) ? true : false,	businessTestFile);
	}
	
	@Test
	void testCustomerRestEndpointForFindAllCustomersIsExposedAndWorking() throws Exception {
		List<CustomerDto> list = new ArrayList<>();
		list.add(MasterData.getCustomerDto());
		Mockito.when(customerService.getAllCustomers()).thenReturn(list);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/customerservice/getall")
				.content(MasterData.asJsonString(MasterData.getCustomerDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result.getResponse().getContentAsString().contentEquals(asJsonString(list))? true : false),	businessTestFile);
	}
	
	@Test
	void testCustomerRestEndpointForDeleteCustomersById() throws Exception {
		CustomerDto CustomerDto = MasterData.getCustomerDto();
		Integer id = CustomerDto.getCustomerId();
		Mockito.when(customerService.deleteCustomer(id)).thenReturn(CustomerDto);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/customerservice/delete/"+id)
				.content(MasterData.asJsonString(MasterData.getCustomerDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result!=null ? "true" : "false"),	businessTestFile);
	}
	
	@Test
	void testCustomerRestEndpointForUpdateCustomer() throws Exception {
		CustomerDto CustomerDto = MasterData.getCustomerDto();
		Mockito.when(customerService.updateCustomer(CustomerDto)).thenReturn(CustomerDto);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/customerservice/update")
				.content(MasterData.asJsonString(MasterData.getCustomerDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result.getResponse() != null) ? true : false,	businessTestFile);
	}
}
