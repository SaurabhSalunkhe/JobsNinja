package com.saurabh.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.saurabh.pojo.Applicant;
import com.saurabh.pojo.Employer;

public class EmployerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Employer employer = (Employer) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "workContact", "error.invalid.user", "Last Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "error.invalid.user", "Last Name Required");
		if(employer.getFirstName().contains("<")||employer.getLastName().contains("<")){
			errors.rejectValue("firstName", "firstName.sqlInjection", "Special characters not allowed");
		}
		if(employer.getWorkContact().length()<10){
			errors.rejectValue("workContact", "firstName.sqlInjection", "Enter valid contact number");
		}
		
	}

}
