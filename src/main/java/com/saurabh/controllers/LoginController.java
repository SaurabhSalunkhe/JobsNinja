package com.saurabh.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.saurabh.dao.ApplicantDAO;
import com.saurabh.dao.EmployerDAO;
import com.saurabh.dao.UserDAO;
import com.saurabh.pojo.Applicant;
import com.saurabh.pojo.Employer;

@Controller
public class LoginController {
	
	@Autowired
	UserDAO userDao;
	
	@Autowired 
	ApplicantDAO applicantDao;
	
	@Autowired
	private EmployerDAO employerDao;
	
	//This method redirects to invalid page incase there is no session
	@RequestMapping(value = "/badAuthentication", method = RequestMethod.GET)
	public ModelAndView badAuthentication(Model model,HttpServletRequest request) throws Exception {
		return new ModelAndView("invalidPage");
	}
	
	//This method gets the credentials from the front end, checks if the user is employer or applicant and accordingly redirects to respective home page
	@RequestMapping(value = "/loginSubmit", method = RequestMethod.POST)
	public ModelAndView loginSubmit(Model model,HttpServletRequest request) throws Exception {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String user=request.getParameter("user");
		if(user.equalsIgnoreCase("employer"))
		{
			Employer employer=employerDao.getEmployer(email, password);
			if(employer==null)
			{
				return new ModelAndView("invalidPage");
			}
			request.getSession().setAttribute("employer", employer);
			return new ModelAndView("employerHomePage","employer",employer);
		}
		else if(user.equalsIgnoreCase("applicant"))
		{
			Applicant applicant=applicantDao.getApplicant(email, password);
			if(applicant==null)
			{
				return new ModelAndView("invalidPage");
			}
			request.getSession().setAttribute("applicant", applicant);
			return new ModelAndView("applicantHomePage","applicant",applicant);
		}
		return new ModelAndView("home");
	}
	
}
