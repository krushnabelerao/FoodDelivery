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

import com.example.fooddelivery.controller.CategoryController;
import com.example.fooddelivery.dto.CategoryDto;
import com.example.fooddelivery.services.CategoryService;
@Order(2)
@WebMvcTest(CategoryController.class)
@AutoConfigureMockMvc
public class TestCategoryException {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CategoryService categoryService;
	
	@Test
	public void testCategoryExceptionDataValidationCheckIsAddedInController() throws Exception {
		CategoryDto CategoryDto = com.example.utils.MasterData.getCategoryDto();
		ExceptionResponse exResponse = new ExceptionResponse(
				"Data Not Added", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(categoryService.saveCategory(CategoryDto))
				.thenThrow(new CommonException("Data Not Added"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/categoryservice/add")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(), (result.getResponse().getStatus() == 400 && exResponse != null) ? true : false, exceptionTestFile);

	}
	
	@Test
	void testCategoryExceptionIsThrownAndHandledIfAdminNotAvailableWhileGettingAllCategorys() throws Exception {
		ExceptionResponse exResponse = new ExceptionResponse(
				"Data Not Found", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(categoryService.getAllCategories())
				.thenThrow(new CommonException("Data Not Found"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/categoryservice/getall")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == 400 && exResponse!=null ? true : false),
				exceptionTestFile);

	}

	@Test
	void testCategoryExceptionIsThrownAndHandledIfCategoryIdIsNotValidWhileDeleting() throws Exception {

		CategoryDto CategoryDto = com.example.utils.MasterData.getCategoryDto();
		Integer id = CategoryDto.getCategoryId();

		ExceptionResponse exResponse = new ExceptionResponse(
				"Category with Id - " + id + " not found!", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(this.categoryService.deleteCategory(id))
				.thenThrow(new CommonException("Category with Id - " + id + " not found!"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/categoryservice/delete/" + id)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == 400 && exResponse!=null) ? true : false,
				exceptionTestFile);
	}
	
	@Test
	void testCategoryExceptionIsThrownAndHandledIfCategoryWhileUpdating() throws Exception {

		CategoryDto CategoryDto = com.example.utils.MasterData.getCategoryDto();

		ExceptionResponse exResponse = new ExceptionResponse(
				"Category not get Updated", System.currentTimeMillis(), HttpStatus.NOT_FOUND.value());
		Mockito.when(this.categoryService.updateCategory(CategoryDto))
				.thenThrow(new CommonException("Category not get Updated"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/categoryservice/update")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == 400 && exResponse!=null) ? true : false,
				exceptionTestFile);
	}
}
