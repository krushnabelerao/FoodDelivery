package com.example.fooddelivery.boundary;
import static com.example.utils.TestUtils.boundaryTestFile;
import static com.example.utils.TestUtils.currentTest;
import static com.example.utils.TestUtils.yakshaAssert;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.core.annotation.Order;

import com.example.fooddelivery.dto.CategoryDto;
import com.example.utils.MasterData;

@Order(3)
public class CategoryBoundaryTests {
	
	
	private static Validator validator;
	
	

    //----------------------------------------------------------------------------------------------
    @BeforeAll
    public static void setUp() {
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
	
    @Test
	public void testHibernateValidationIsAddedToCheckIfNameIsNotNull() throws Exception {
    	CategoryDto categoryDto = MasterData.getCategoryDto();
    	categoryDto.setName("");
		Set<ConstraintViolation<CategoryDto>> violations = validator.validate(categoryDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}

	@Test
	public void testHibernateValidationIsAddedToCheckIfNameIsNotLessThanFiveChars() throws Exception {
		CategoryDto categoryDto = MasterData.getCategoryDto();
		categoryDto.setName("Pra");
		Set<ConstraintViolation<CategoryDto>> violations = validator.validate(categoryDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfNameIsNotMoreThanTwentyChars() throws Exception {
		CategoryDto categoryDto = MasterData.getCategoryDto();
		String name = "";
		for(int i=0;i<25;i++) {
			name.concat("A");
		}
		categoryDto.setName(name);
		Set<ConstraintViolation<CategoryDto>> violations = validator.validate(categoryDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}
	 
	@Test
	public void testHibernateValidationIsAddedToCheckIfCategoryDtoTypeofcatIsNotNull() throws Exception {
		CategoryDto categoryDto = MasterData.getCategoryDto();
		categoryDto.setTypeOfCat("");
		Set<ConstraintViolation<CategoryDto>> violations = validator.validate(categoryDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
			
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfCategoryDtoTypeofcatIsNotLessThanFiveChars() throws Exception {
		CategoryDto categoryDto = MasterData.getCategoryDto();
		categoryDto.setTypeOfCat("Dev");
		Set<ConstraintViolation<CategoryDto>> violations = validator.validate(categoryDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
			
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfCategoryDtoTypeofcatIsNotMoreThanTwentyChars() throws Exception {
		CategoryDto categoryDto = MasterData.getCategoryDto();
		String name = "";
		for(int i=0;i<25;i++) {
			name.concat("A");
		}
		categoryDto.setTypeOfCat(name);
		Set<ConstraintViolation<CategoryDto>> violations = validator.validate(categoryDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
			
	}
	
}
