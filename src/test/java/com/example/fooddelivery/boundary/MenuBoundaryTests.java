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

import com.example.fooddelivery.dto.MenuDto;
import com.example.utils.MasterData;

@Order(3)
public class MenuBoundaryTests {
	
private static Validator validator;

    //----------------------------------------------------------------------------------------------
    @BeforeAll
    public static void setUp() {
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
	
    @Test
	public void testHibernateValidationIsAddedToCheckIfTitleIsNotNull() throws Exception {
    	MenuDto menuDto = MasterData.getMenuDto();
    	menuDto.setTitle("");
		Set<ConstraintViolation<MenuDto>> violations = validator.validate(menuDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}

	@Test
	public void testHibernateValidationIsAddedToCheckIfTitleIsNotLessThanFiveChars() throws Exception {
		MenuDto menuDto = MasterData.getMenuDto();
		menuDto.setTitle("Pra");
		Set<ConstraintViolation<MenuDto>> violations = validator.validate(menuDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfTitleIsNotMoreThanTwentyChars() throws Exception {
		MenuDto menuDto = MasterData.getMenuDto();
		String name = "";
		for(int i=0;i<25;i++) {
			name.concat("A");
		}
		menuDto.setTitle(name);
		Set<ConstraintViolation<MenuDto>> violations = validator.validate(menuDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}
	
	 @Test
		public void testHibernateValidationIsAddedToCheckIfMenutypeIsNotNull() throws Exception {
	    	MenuDto menuDto = MasterData.getMenuDto();
	    	menuDto.setMenuType("");
			Set<ConstraintViolation<MenuDto>> violations = validator.validate(menuDto);
			yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
		}

		@Test
		public void testHibernateValidationIsAddedToCheckIfMenutypeIsNotLessThanFiveChars() throws Exception {
			MenuDto menuDto = MasterData.getMenuDto();
			menuDto.setMenuType("Pra");
			Set<ConstraintViolation<MenuDto>> violations = validator.validate(menuDto);
			yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
		}
		
		@Test
		public void testHibernateValidationIsAddedToCheckIfMenutypeIsNotMoreThanTwentyChars() throws Exception {
			MenuDto menuDto = MasterData.getMenuDto();
			String name = "";
			for(int i=0;i<25;i++) {
				name.concat("A");
			}
			menuDto.setMenuType(name);
			Set<ConstraintViolation<MenuDto>> violations = validator.validate(menuDto);
			yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
		}

}
