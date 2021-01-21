package com.order.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Agevalidator implements ConstraintValidator<Age, Integer> {

	private int lower;
	private int upper;
	
	@Override
	public void initialize(Age age) {
		
		this.lower=age.lower();
		this.upper=age.upper();
		
		
		
	}
	
	
	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		
		if(age==null) {
			
			return false; // Fail
			
		}if(  age < lower|| age>upper) {
			
			
			return false;// fail
			
		}else return true;
		
		
		
		
		
	}

}
