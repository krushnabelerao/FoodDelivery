//package com.example.fooddelivery.exception;
//import static com.example.utils.TestUtils.currentTest;
//import static com.example.utils.TestUtils.exceptionTestFile;
//import static com.example.utils.TestUtils.yakshaAssert;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.example.saloonapi.controller.ShopController;
//import com.example.saloonapi.dto.ShopDto;
//import com.example.saloonapi.dto.ShopExceptionResponse;
//import com.example.saloonapi.model.Shop;
//import com.example.saloonapi.service.ShopService;
//
//@Order(2)
//@WebMvcTest(ShopController.class)
//@AutoConfigureMockMvc
//public class TestExceptions {
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@MockBean
//	private ShopService shopService;
//
//	
//	
//	
//		// Exception
//		@Test
//		public void testDataValidationCheckIsAddedInController() throws Exception {
//			Shop shopDto = com.example.utils.MasterData.getShop();
//			shopDto.setAddress("pr");
//			Mockito.when(shopService.addShop(shopDto))
//			.thenReturn(shopDto);
//			
//			RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/shopservice/add")
//					.content(com.example.utils.MasterData.asJsonString(shopDto))
//					.contentType(MediaType.APPLICATION_JSON)
//					.accept(MediaType.APPLICATION_JSON);
//					
//			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//			
//			System.out.println(result.getResponse().getStatus());
//			yakshaAssert(currentTest(),
//					result.getResponse().getStatus() == 200? true : false,
//							exceptionTestFile);
//					
//		}
//		
//		@Test
//		public void testAbleToWorkWithCustomExceptions() throws Exception {
//			Shop shopDto = com.example.utils.MasterData.getShop();
//			shopDto.setAddress("pune");
//			Mockito.when(shopService.addShop(shopDto))
//			.thenReturn(shopDto);
//			
//			RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/shopservice/add")
//					.content(com.example.utils.MasterData.asJsonString(shopDto))
//					.contentType(MediaType.APPLICATION_JSON)
//					.accept(MediaType.APPLICATION_JSON);
//					
//			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//			
//			
//			yakshaAssert(currentTest(),
//					result.getResponse().getStatus() == 200? true : false,
//							exceptionTestFile);
//					
//		}
//		
//		@Test
//		public void testExceptionIsThrownAndHandledInCaseOfInvalidData() throws Exception {
//			Shop shopDto = com.example.utils.MasterData.getShop();
//			shopDto.setAddress("pune");
//			Mockito.when(shopService.addShop(shopDto))
//			.thenReturn(shopDto);
//			
//			RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/shopservice/add")
//					.content(com.example.utils.MasterData.asJsonString(shopDto))
//					.contentType(MediaType.APPLICATION_JSON)
//					.accept(MediaType.APPLICATION_JSON);
//					
//			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//			
//			
//			yakshaAssert(currentTest(),
//					result.getResponse().getStatus() == 200? true : false,
//							exceptionTestFile);
//					
//		}
//		
//		@Test
//		void testExceptionIsThrownAndHandledIfShopIdIsNotValidWhileDeleting() throws Exception{
//			
//			ShopDto shopDto = com.example.utils.MasterData.getShopDto();
//			Integer id = shopDto.getId();
//			
//			ShopExceptionResponse exResponse = new ShopExceptionResponse("", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
//			
//			RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/shopservice/delete/" + id)
//					.contentType(MediaType.APPLICATION_JSON)
//					.accept(MediaType.APPLICATION_JSON);
//					
//			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//			yakshaAssert(currentTest(),
//					result.getResponse().getContentAsString().contains(exResponse.getMessage())? true : false,exceptionTestFile);
//			
//		}
//	
//		@Test
//		void testExceptionIsThrownAndHandledIfShopIdIsNotValidWhileGettingNoteById() throws Exception{
//			ShopDto shopDto = com.example.utils.MasterData.getShopDto();
//			Integer id = shopDto.getId();
//			
//			ShopExceptionResponse exResponse = new ShopExceptionResponse("", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
//			
//			RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/shopservice/get/" + id)
//					.contentType(MediaType.APPLICATION_JSON)
//					.accept(MediaType.APPLICATION_JSON);
//					
//			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//			yakshaAssert(currentTest(),
//					(result.getResponse().getContentAsString().contains(exResponse.getMessage())? true : false),exceptionTestFile);
//			
//		}
//		
//		@Test
//		public void testExceptionIsThrownAndHandledIfShopIdIsNotValidWhileUpdating() throws Exception{
//			ShopDto shopDto = com.example.utils.MasterData.getShopDto();
//			Integer id = 10001;
//			String status="pending";
//			shopDto.setId(id);
//			shopDto.setStatus(status);
//			ShopExceptionResponse exResponse = new ShopExceptionResponse("", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
//			RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/shopservice/update/"+id+"/"+status)
//							.contentType(MediaType.APPLICATION_JSON)
//							.accept(MediaType.APPLICATION_JSON);
//			
//			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//			
//			yakshaAssert(currentTest(),
//					result.getResponse().getContentAsString().contains(exResponse.getMessage())? true : false,
//							exceptionTestFile);
//		}
//	
//}
