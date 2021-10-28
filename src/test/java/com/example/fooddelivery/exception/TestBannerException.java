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

import com.example.fooddelivery.controller.BannerController;
import com.example.fooddelivery.dto.BannerDto;
import com.example.fooddelivery.services.BannerService;
@Order(2)
@WebMvcTest(BannerController.class)
@AutoConfigureMockMvc
public class TestBannerException {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BannerService bannerService;
	
	@Test
	public void testBannerExceptionDataValidationCheckIsAddedInController() throws Exception {
		BannerDto bannerDto = com.example.utils.MasterData.getBannerDto();
		ExceptionResponse exResponse = new ExceptionResponse(
				"Data Not Added", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(bannerService.saveBanner(bannerDto))
				.thenThrow(new CommonException("Data Not Added"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/bannerservice/add")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), (result.getResponse().getStatus() == 400 && exResponse != null) ? true : false, exceptionTestFile);

	}
	
	@Test
	void testBannerExceptionIsThrownAndHandledIfAdminNotAvailableWhileGettingAllBanners() throws Exception {
		ExceptionResponse exResponse = new ExceptionResponse(
				"Data Not Found", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(bannerService.getAllBanners())
				.thenThrow(new CommonException("Data Not Found"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/bannerservice/getall")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == 400 && exResponse!=null ? true : false),
				exceptionTestFile);

	}

	@Test
	void testBannerExceptionIsThrownAndHandledIfBannerIdIsNotValidWhileDeleting() throws Exception {

		BannerDto bannerDto = com.example.utils.MasterData.getBannerDto();
		Integer id = bannerDto.getBannerId();

		ExceptionResponse exResponse = new ExceptionResponse(
				"Banner with Id - " + id + " not found!", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(this.bannerService.deleteBanner(id))
				.thenThrow(new CommonException("Banner with Id - " + id + " not found!"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/bannerservice/delete/" + id)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == 400 && exResponse!=null) ? true : false,
				exceptionTestFile);
	}
	
	@Test
	void testBannerExceptionIsThrownAndHandledIfBannerWhileUpdating() throws Exception {

		BannerDto bannerDto = com.example.utils.MasterData.getBannerDto();

		ExceptionResponse exResponse = new ExceptionResponse(
				"Banner not get Updated", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(this.bannerService.updateBanner(bannerDto))
				.thenThrow(new CommonException("Banner not get Updated"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/bannerservice/update")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == 400 && exResponse!=null) ? true : false,
				exceptionTestFile);
	}
}
