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

import com.example.fooddelivery.dto.CustomerDto;
import com.example.utils.MasterData;

@Order(3)
public class CustomerBoundaryTests {
private static Validator validator;
	
	

    //----------------------------------------------------------------------------------------------
    @BeforeAll
    public static void setUp() {
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
	
    @Test
	public void testHibernateValidationIsAddedToCheckIfNameIsNotNull() throws Exception {
    	CustomerDto customerDto = MasterData.getCustomerDto();
    	customerDto.setName("");
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}

	@Test
	public void testHibernateValidationIsAddedToCheckIfNameIsNotLessThanFiveChars() throws Exception {
		CustomerDto customerDto = MasterData.getCustomerDto();
		customerDto.setName("Pra");
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfNameIsNotMoreThanTwentyChars() throws Exception {
		CustomerDto customerDto = MasterData.getCustomerDto();
		String name = "";
		for(int i=0;i<25;i++) {
			name.concat("A");
		}
		customerDto.setName(name);
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfEmailIsNotNull() throws Exception {
    	CustomerDto customerDto = MasterData.getCustomerDto();
    	customerDto.setEmail("");
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}

	@Test
	public void testHibernateValidationIsAddedToCheckIfEmailIsNotLessThanFiveChars() throws Exception {
		CustomerDto customerDto = MasterData.getCustomerDto();
		customerDto.setEmail("Pra");
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfEmailIsNotMoreThanTwentyChars() throws Exception {
		CustomerDto customerDto = MasterData.getCustomerDto();
		String name = "";
		for(int i=0;i<25;i++) {
			name.concat("A");
		}
		customerDto.setEmail(name);
		Set<ConstraintViolation<CustomerDto>> violations = validator.validate(customerDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}

}
