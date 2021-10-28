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

import com.example.fooddelivery.controller.CategoryController;
import com.example.fooddelivery.dto.CategoryDto;
import com.example.fooddelivery.services.CategoryService;
import com.example.utils.MasterData;

@Order(1)
@WebMvcTest(CategoryController.class)
@AutoConfigureMockMvc
public class CategoryControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private CategoryService categoryService;
	
	@Test
	void testCategoryRestEndpointForAddNewCategory() throws Exception {
		CategoryDto CategoryDto = MasterData.getCategoryDto();
		Mockito.when(categoryService.saveCategory(CategoryDto)).thenReturn(CategoryDto);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/categoryservice/add")
				.content(MasterData.asJsonString(MasterData.getCategoryDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result.getResponse() != null) ? true : false,	businessTestFile);
	}
	
	@Test
	void testCategoryRestEndpointForFindAllCategorysIsExposedAndWorking() throws Exception {
		List<CategoryDto> list = new ArrayList<>();
		list.add(MasterData.getCategoryDto());
		Mockito.when(categoryService.getAllCategories()).thenReturn(list);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/categoryservice/getall")
				.content(MasterData.asJsonString(MasterData.getCategoryDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result.getResponse().getContentAsString().contentEquals(asJsonString(list))? true : false),	businessTestFile);
	}
	
	@Test
	void testCategoryRestEndpointForDeleteCategorysById() throws Exception {
		CategoryDto CategoryDto = MasterData.getCategoryDto();
		Integer id = CategoryDto.getCategoryId();
		Mockito.when(categoryService.deleteCategory(id)).thenReturn(CategoryDto);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/categoryservice/delete/"+id)
				.content(MasterData.asJsonString(MasterData.getCategoryDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result!=null ? "true" : "false"),	businessTestFile);
	}
	
	@Test
	void testCategoryRestEndpointForUpdateCategory() throws Exception {
		CategoryDto CategoryDto = MasterData.getCategoryDto();
		Mockito.when(categoryService.updateCategory(CategoryDto)).thenReturn(CategoryDto);
				RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/categoryservice/update")
				.content(MasterData.asJsonString(MasterData.getCategoryDto()))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		 
		yakshaAssert(currentTest(), 
				(result.getResponse() != null) ? true : false,	businessTestFile);
	}
}
