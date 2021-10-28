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

import com.example.fooddelivery.dto.BannerDto;
import com.example.utils.MasterData;

@Order(3)
public class BannerBoundaryTests {
	
	
	private static Validator validator;
	
	

    //----------------------------------------------------------------------------------------------
    @BeforeAll
    public static void setUp() {
    	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
	
    @Test
	public void testHibernateValidationIsAddedToCheckIfDescriptionIsNotNull() throws Exception {
    	BannerDto bannerDto = MasterData.getBannerDto();
    	bannerDto.setDescription("");
		Set<ConstraintViolation<BannerDto>> violations = validator.validate(bannerDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}

	@Test
	public void testHibernateValidationIsAddedToCheckIfDescriptionIsNotLessThanFiveChars() throws Exception {
		BannerDto bannerDto = MasterData.getBannerDto();
		bannerDto.setDescription("Pra");
		Set<ConstraintViolation<BannerDto>> violations = validator.validate(bannerDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfDescriptionIsNotMoreThanTwentyChars() throws Exception {
		BannerDto bannerDto = MasterData.getBannerDto();
		String name = "";
		for(int i=0;i<25;i++) {
			name.concat("A");
		}
		bannerDto.setDescription(name);
		Set<ConstraintViolation<BannerDto>> violations = validator.validate(bannerDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
	}
	 
	@Test
	public void testHibernateValidationIsAddedToCheckIfBannerDtoNameIsNotNull() throws Exception {
		BannerDto bannerDto = MasterData.getBannerDto();
		bannerDto.setName("");
		Set<ConstraintViolation<BannerDto>> violations = validator.validate(bannerDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
			
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfBannerDtoNameIsNotLessThanFiveChars() throws Exception {
		BannerDto bannerDto = MasterData.getBannerDto();
		bannerDto.setName("Dev");
		Set<ConstraintViolation<BannerDto>> violations = validator.validate(bannerDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
			
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfBannerDtoNameIsNotMoreThanTwentyChars() throws Exception {
		BannerDto bannerDto = MasterData.getBannerDto();
		String name = "";
		for(int i=0;i<25;i++) {
			name.concat("A");
		}
		bannerDto.setName(name);
		Set<ConstraintViolation<BannerDto>> violations = validator.validate(bannerDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
			
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfTypeIsNotNull() throws Exception {
		BannerDto bannerDto = MasterData.getBannerDto();
		bannerDto.setType("");
		Set<ConstraintViolation<BannerDto>> violations = validator.validate(bannerDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
			
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfTypeIsNotLessThanFiveChars() throws Exception {
		BannerDto bannerDto = MasterData.getBannerDto();
		bannerDto.setType("Test");
		Set<ConstraintViolation<BannerDto>> violations = validator.validate(bannerDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
			
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfDescriptionIsNotMoreThanTwoHundredChars() throws Exception {
		BannerDto bannerDto = MasterData.getBannerDto();
		String name = "";
		for(int i=0;i<225;i++) {
			name.concat("A");
		}
		bannerDto.setType(name);
		Set<ConstraintViolation<BannerDto>> violations = validator.validate(bannerDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
			
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfAlltextIsNotNull() throws Exception {
		BannerDto bannerDto = MasterData.getBannerDto();
		bannerDto.setAllText("");
		Set<ConstraintViolation<BannerDto>> violations = validator.validate(bannerDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
			
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfAlltextIsNotLessThanFiveChars() throws Exception {
		BannerDto bannerDto = MasterData.getBannerDto();
		bannerDto.setAllText("Test");
		Set<ConstraintViolation<BannerDto>> violations = validator.validate(bannerDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
			
	}
	
	@Test
	public void testHibernateValidationIsAddedToCheckIfAlltextIsNotMoreThanTwoHundredChars() throws Exception {
		BannerDto bannerDto = MasterData.getBannerDto();
		String name = "";
		for(int i=0;i<225;i++) {
			name.concat("A");
		}
		bannerDto.setAllText(name);
		Set<ConstraintViolation<BannerDto>> violations = validator.validate(bannerDto);
		yakshaAssert(currentTest(),!violations.isEmpty()? true : false,boundaryTestFile);
			
	}
	
}
