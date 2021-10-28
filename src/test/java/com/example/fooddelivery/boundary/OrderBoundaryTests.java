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

import com.example.fooddelivery.dto.OrderDto;
import com.example.utils.MasterData;
@Order(3)
public class OrderBoundaryTests {
	private static Validator validator;

    //----------------------------------------------------------------------------------------------
    @BeforeAll
    public static void setUp() {
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Test
	public void testHibernateValidationIsAddedToCheckIfResaddressIsNotNull() throws Exception {
    	OrderDto orderDto = MasterData.getOrderDto();
    	orderDto.setResAddress("");
		Set<ConstraintViolation<OrderDto>> violations = validator.validate(orderDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}

	@Test
	public void testHibernateValidationIsAddedToCheckIfResaddressIsNotLessThanFiveChars() throws Exception {
		OrderDto orderDto = MasterData.getOrderDto();
		orderDto.setResAddress("Pra");
		Set<ConstraintViolation<OrderDto>> violations = validator.validate(orderDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfResaddressIsNotMoreThanTwentyChars() throws Exception {
		OrderDto orderDto = MasterData.getOrderDto();
		String name = "";
		for(int i=0;i<25;i++) {
			name.concat("A");
		}
		orderDto.setResAddress(name);
		Set<ConstraintViolation<OrderDto>> violations = validator.validate(orderDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfResphonenoIsNotNull() throws Exception {
    	OrderDto orderDto = MasterData.getOrderDto();
    	orderDto.setResPhoneNo("");
		Set<ConstraintViolation<OrderDto>> violations = validator.validate(orderDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}

	@Test
	public void testHibernateValidationIsAddedToCheckIfResphonenoIsNotLessThanFiveChars() throws Exception {
		OrderDto orderDto = MasterData.getOrderDto();
		orderDto.setResPhoneNo("Pra");
		Set<ConstraintViolation<OrderDto>> violations = validator.validate(orderDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfResphonenoIsNotMoreThanTwentyChars() throws Exception {
		OrderDto orderDto = MasterData.getOrderDto();
		String name = "";
		for(int i=0;i<25;i++) {
			name.concat("A");
		}
		orderDto.setResPhoneNo(name);
		Set<ConstraintViolation<OrderDto>> violations = validator.validate(orderDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}

}
