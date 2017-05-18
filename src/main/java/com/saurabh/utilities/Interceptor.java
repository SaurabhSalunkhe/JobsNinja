package com.saurabh.utilities;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.saurabh.pojo.Applicant;
import com.saurabh.pojo.Employer;


@Component
public class Interceptor extends HandlerInterceptorAdapter
{
 @Override
 public boolean preHandle(HttpServletRequest request,
   HttpServletResponse response, Object handler) throws Exception
 {
  String uri = request.getRequestURI();
  if(!uri.endsWith("logout")&&!uri.endsWith("/jobsninja/")&&!uri.endsWith("loginSubmit") && !uri.endsWith("invalidLogin")
		  &&!uri.endsWith("applicantsignuppage") && !uri.endsWith("employersignuppage")
		  &&!uri.endsWith("applicantSignUpSubmit") && !uri.endsWith("employerSignUpSubmit"))
     {
	  Employer employer;
	  Applicant applicant;
	   try
	   {
		   employer = (Employer) request.getSession().getAttribute("employer"); 
	   }
	   catch(Exception ex)
	   {
		   employer=null;
	   }
	   try
	   {
		   applicant=(Applicant) request.getSession().getAttribute("applicant"); 
	   }
	   catch(Exception ex)
	   {
		   applicant=null;
	   }
	   
	   if(employer == null && applicant==null)
	   {
	    response.sendRedirect("/jobsninja/badAuthentication");
	    return false;
	   }   
  }
  return true;
 }
}