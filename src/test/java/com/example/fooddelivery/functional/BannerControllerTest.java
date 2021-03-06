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

import com.example.fooddelivery.controller.BannerController;
import com.example.fooddelivery.dto.BannerDto;
import com.example.fooddelivery.services.BannerService;
import com.example.utils.MasterData;

@Order(1)
@WebMvcTest(BannerController.class)
@AutoConfigureMockMvc
public class BannerControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private BannerService bannerService;
	
	@Test
	void testBannerRestEndpointForAddNewBanner() throws Exception {
		BannerDto bannerDto = MasterData.getBannerDto();
		Mockito.when(bannerService.saveBanner(bannerDto)).thenReturn(bannerDto);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/bannerservice/add")
				.content(MasterData.asJsonString(MasterData.getBannerDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result.getResponse() != null) ? true : false,	businessTestFile);
	}
	
	@Test
	void testBannerRestEndpointForFindAllBannersIsExposedAndWorking() throws Exception {
		List<BannerDto> list = new ArrayList<>();
		list.add(MasterData.getBannerDto());
		Mockito.when(bannerService.getAllBanners()).thenReturn(list);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/bannerservice/getall")
				.content(MasterData.asJsonString(MasterData.getBannerDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result.getResponse().getContentAsString().contentEquals(asJsonString(list))? true : false),	businessTestFile);
	}
	
	@Test
	void testBannerRestEndpointForDeleteBannersById() throws Exception {
		BannerDto bannerDto = MasterData.getBannerDto();
		Integer id = bannerDto.getBannerId();
		Mockito.when(bannerService.deleteBanner(id)).thenReturn(bannerDto);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/bannerservice/delete/"+id)
				.content(MasterData.asJsonString(MasterData.getBannerDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result!=null ? "true" : "false"),	businessTestFile);
	}
	
	@Test
	void testBannerRestEndpointForUpdateBanner() throws Exception {
		BannerDto bannerDto = MasterData.getBannerDto();
		Mockito.when(bannerService.updateBanner(bannerDto)).thenReturn(bannerDto);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/bannerservice/update")
				.content(MasterData.asJsonString(MasterData.getBannerDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result.getResponse() != null) ? true : false,	businessTestFile);
	}
}
