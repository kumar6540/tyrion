package com.order.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.order.Data.RegistrationDto;

public class NamespringValidator implements Validator {

	/*
	 * @MXBean ApiValidationRouter apiValidationRouter;
	 * 
	 * @Before public void beforeClass() throws Exception {
	 * when(apiValidationRouter.supports(any())).thenReturn(true); }
	 */
	
	@Override
	public boolean supports(Class<?> clazz) {
	
		return RegistrationDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.empty", "asdfasdf");
		
		
		  String email= ((RegistrationDto)target).getCommunicationdto().getEmail();
		  
		  if(!email.contains("@gmail.com")) {
		  
		  errors.rejectValue("communicationdto.Email", "Email.invalid",
		  "{Email.invalid}"); }
		 
		
		
	}

}
