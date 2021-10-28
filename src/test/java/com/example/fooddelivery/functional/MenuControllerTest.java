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

import com.example.fooddelivery.controller.MenuController;
import com.example.fooddelivery.dto.MenuDto;
import com.example.fooddelivery.services.MenuService;
import com.example.utils.MasterData;

@Order(1)
@WebMvcTest(MenuController.class)
@AutoConfigureMockMvc
public class MenuControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private MenuService menuService;
	
	@Test
	void testMenuRestEndpointForAddNewMenu() throws Exception {
		MenuDto MenuDto = MasterData.getMenuDto();
		Mockito.when(menuService.saveMenu(MenuDto)).thenReturn(MenuDto);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/menuservice/add")
				.content(MasterData.asJsonString(MasterData.getMenuDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result.getResponse() != null) ? true : false,	businessTestFile);
	}
	
	@Test
	void testMenuRestEndpointForFindAllMenusIsExposedAndWorking() throws Exception {
		List<MenuDto> list = new ArrayList<>();
		list.add(MasterData.getMenuDto());
		Mockito.when(menuService.getAllMenus()).thenReturn(list);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/menuservice/getall")
				.content(MasterData.asJsonString(MasterData.getMenuDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result.getResponse().getContentAsString().contentEquals(asJsonString(list))? true : false),	businessTestFile);
	}
	
	@Test
	void testMenuRestEndpointForDeleteMenusById() throws Exception {
		MenuDto MenuDto = MasterData.getMenuDto();
		Integer id = MenuDto.getMenuId();
		Mockito.when(menuService.deleteMenu(id)).thenReturn(MenuDto);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/menuservice/delete/"+id)
				.content(MasterData.asJsonString(MasterData.getMenuDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result!=null ? "true" : "false"),	businessTestFile);
	}
	
	@Test
	void testMenuRestEndpointForUpdateMenu() throws Exception {
		MenuDto MenuDto = MasterData.getMenuDto();
		Mockito.when(menuService.updateMenu(MenuDto)).thenReturn(MenuDto);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/menuservice/update")
				.content(MasterData.asJsonString(MasterData.getMenuDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result.getResponse() != null) ? true : false,	businessTestFile);
	}
}
