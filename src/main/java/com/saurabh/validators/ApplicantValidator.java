package com.saurabh.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.saurabh.pojo.Applicant;


public class ApplicantValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Applicant applicant=(Applicant)obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNumber", "error.invalid.user", "Last Name Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "error.invalid.user", "Contact Number Required");
		if(applicant.getFirstName().contains("<")||applicant.getLastName().contains("<")){
			errors.rejectValue("firstName", "firstName.sqlInjection", "Special characters not allowed");
		}
		if(applicant.getContactNumber().length()<10){
			errors.rejectValue("contactNumber", "firstName.sqlInjection", "Enter valid contact number");
		}
		
	}

}
