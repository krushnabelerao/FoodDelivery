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

import com.example.fooddelivery.controller.MenuController;
import com.example.fooddelivery.dto.MenuDto;
import com.example.fooddelivery.services.MenuService;
@Order(2)
@WebMvcTest(MenuController.class)
@AutoConfigureMockMvc
public class TestMenuException {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MenuService menuService;
	
	@Test
	public void testMenuExceptionDataValidationCheckIsAddedInController() throws Exception {
		MenuDto menuDto = com.example.utils.MasterData.getMenuDto();
		ExceptionResponse exResponse = new ExceptionResponse(
				"Data Not Added", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(menuService.saveMenu(menuDto))
				.thenThrow(new CommonException("Data Not Added"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/menuservice/add")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), (result.getResponse().getStatus() == 400 && exResponse != null) ? true : false, exceptionTestFile);

	}
	
	@Test
	void testMenuExceptionIsThrownAndHandledIfAdminNotAvailableWhileGettingAllMenus() throws Exception {
		ExceptionResponse exResponse = new ExceptionResponse(
				"Data Not Found", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(menuService.getAllMenus())
				.thenThrow(new CommonException("Data Not Found"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/menuservice/getall")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == 400 && exResponse!=null ? true : false),
				exceptionTestFile);

	}

	@Test
	void testMenuExceptionIsThrownAndHandledIfMenuIdIsNotValidWhileDeleting() throws Exception {

		MenuDto menuDto = com.example.utils.MasterData.getMenuDto();
		Integer id = menuDto.getMenuId();

		ExceptionResponse exResponse = new ExceptionResponse(
				"Menu with Id - " + id + " not found!", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(this.menuService.deleteMenu(id))
				.thenThrow(new CommonException("Menu with Id - " + id + " not found!"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/menuservice/delete/" + id)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == 400 && exResponse!=null) ? true : false,
				exceptionTestFile);
	}
	
	@Test
	void testMenuExceptionIsThrownAndHandledIfMenuWhileUpdating() throws Exception {

		MenuDto menuDto = com.example.utils.MasterData.getMenuDto();

		ExceptionResponse exResponse = new ExceptionResponse(
				"Menu not get Updated", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(this.menuService.updateMenu(menuDto))
				.thenThrow(new CommonException("Menu not get Updated"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/menuservice/update")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == 400 && exResponse!=null) ? true : false,
				exceptionTestFile);
	}
}
