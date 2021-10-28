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

import com.example.fooddelivery.dto.RestaurantDto;
import com.example.utils.MasterData;
@Order(3)
public class RestaurantBoundaryTests {
	private static Validator validator;

    //----------------------------------------------------------------------------------------------
    @BeforeAll
    public static void setUp() {
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Test
	public void testHibernateValidationIsAddedToCheckIfPhonenumberIsNotNull() throws Exception {
    	RestaurantDto restaurantDto = MasterData.getRestaurantDto();
    	restaurantDto.setPhoneNumber("");
		Set<ConstraintViolation<RestaurantDto>> violations = validator.validate(restaurantDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}

	@Test
	public void testHibernateValidationIsAddedToCheckIfPhonenumberIsNotLessThanFiveChars() throws Exception {
		RestaurantDto restaurantDto = MasterData.getRestaurantDto();
		restaurantDto.setPhoneNumber("Pra");
		Set<ConstraintViolation<RestaurantDto>> violations = validator.validate(restaurantDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfPhonenumberIsNotMoreThanTwentyChars() throws Exception {
		RestaurantDto restaurantDto = MasterData.getRestaurantDto();
		String name = "";
		for(int i=0;i<25;i++) {
			name.concat("A");
		}
		restaurantDto.setPhoneNumber(name);
		Set<ConstraintViolation<RestaurantDto>> violations = validator.validate(restaurantDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfPasswordIsNotNull() throws Exception {
    	RestaurantDto restaurantDto = MasterData.getRestaurantDto();
    	restaurantDto.setPassword("");
		Set<ConstraintViolation<RestaurantDto>> violations = validator.validate(restaurantDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}

	@Test
	public void testHibernateValidationIsAddedToCheckIfPasswordIsNotLessThanFiveChars() throws Exception {
		RestaurantDto restaurantDto = MasterData.getRestaurantDto();
		restaurantDto.setPassword("Pra");
		Set<ConstraintViolation<RestaurantDto>> violations = validator.validate(restaurantDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfPasswordIsNotMoreThanTwentyChars() throws Exception {
		RestaurantDto restaurantDto = MasterData.getRestaurantDto();
		String name = "";
		for(int i=0;i<25;i++) {
			name.concat("A");
		}
		restaurantDto.setPassword(name);
		Set<ConstraintViolation<RestaurantDto>> violations = validator.validate(restaurantDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}
}
