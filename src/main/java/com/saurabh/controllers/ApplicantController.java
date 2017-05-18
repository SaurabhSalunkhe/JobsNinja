package com.saurabh.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.saurabh.dao.ApplicantDAO;
import com.saurabh.dao.EmployerDAO;
import com.saurabh.dao.UserDAO;
import com.saurabh.pojo.Applicant;
import com.saurabh.pojo.Application;
import com.saurabh.pojo.Job;
import com.saurabh.pojo.SearchJobFilter;
import com.saurabh.validators.ApplicantValidator;


@Controller
public class ApplicantController {
	

	private ApplicantValidator applicantvalidator=new ApplicantValidator();
	
	@Autowired
	private ApplicantDAO applicantDao;
	
	@Autowired
	EmployerDAO employerDao;
	
	@Autowired
	private UserDAO userDao;
	
	
	//Gets the sign-up page for applicant and passes the applicant object to the new page
	@RequestMapping(value = "/applicantsignuppage", method = RequestMethod.GET)
	public ModelAndView applicantSignUpPage(Model model,HttpServletRequest request)
	{
		return new ModelAndView("applicantSignup","applicant",new Applicant());
	}

	//Gets the current applicant from the session, passes the applicant's applications to the front end for rendering
	@RequestMapping(value = "/myapplications", method = RequestMethod.GET)
	public ModelAndView myapplications(Model model,HttpServletRequest request) throws Exception {
		
		Applicant applicant= (Applicant) request.getSession().getAttribute("applicant");
		return new ModelAndView("applicantApplications","applications",applicant.getApplications());
	}	
	
	
	
		
	//Initially checks for bad input with validators, if not saves the applicant in db, and passes the applicant in the front end
	@RequestMapping(value = "/applicantSignUpSubmit", method = RequestMethod.POST)
	public ModelAndView applicantSignUpSubmit(Model model,Applicant applicant,HttpSession session,BindingResult result) throws Exception
	{
		applicantvalidator.validate(applicant, result);
		
		if(result.hasErrors()){
			return new ModelAndView("applicantSignup");
		}
		
		applicant.setRole("applicant");
		userDao.saveUser(applicant);
		session.setAttribute("applicant", applicant);
		return new ModelAndView("applicantHomePage","applicant",applicant);
		}
	
	
	//Common Logout method for both applicant and employer, redirects to home page after invalidating the session
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView commonLogout(Model model,HttpServletRequest request)
	{
		request.getSession().invalidate();
		return new ModelAndView("home");
	}
	
//	Simply passes the current applicant object in session to the front end for rendering
	@RequestMapping(value = "/applicantProfile", method = RequestMethod.GET)
	public ModelAndView applicantProfile(Model model,HttpServletRequest request) throws Exception
	{
		
		Applicant applicant=(Applicant) request.getSession().getAttribute("applicant");
		return new ModelAndView("applicantProfile","applicant",applicant);
	}
	
	//Get the jobId from string query, retrieve the applicant object from session,pass the jobid and applicant to the next screen 
	@RequestMapping(value = "/viewtoapply", method = RequestMethod.GET)
	public ModelAndView viewToApply(Model model,HttpServletRequest request) throws Exception
	{
		int jobid=Integer.parseInt(request.getParameter("id"));
		Job job= applicantDao.getJobsById(jobid);
		Applicant applicant=(Applicant) request.getSession().getAttribute("applicant");
		int id= applicant.getId();
		applicant= (Applicant) userDao.getUserById(id);
		request.getSession().setAttribute("applicant", applicant);
		return new ModelAndView("viewJobDetails","job", job);
	}
	
	//After applying for job, connect the application with the applicant
	@RequestMapping(value = "/applyToJob", method = RequestMethod.GET)
	public ModelAndView applicantApplyToJob(Model model,HttpServletRequest request) throws Exception
	{
		HttpSession session=request.getSession();
		Applicant applicant=(Applicant) session.getAttribute("applicant");
		int id= applicant.getId();
		int jobid=Integer.parseInt(request.getParameter("id"));
		Job job= applicantDao.getJobsById(jobid);
		Application application = new Application();
		application.setUser(applicant);
		application.setJob(job);
		application.setStatus("Applied");
		applicantDao.saveApplication(application);
		applicant= (Applicant) userDao.getUserById(id);
		session.setAttribute("applicant", applicant);
		return new ModelAndView("jobApplied");
	}
	
	
	@RequestMapping(value = "/uploadResume", method = RequestMethod.GET)
	public ModelAndView applicantResume(Model model,HttpServletRequest request) throws Exception
	{
		Applicant applicant= (Applicant) request.getSession().getAttribute("applicant");
		return new ModelAndView("uploadResume");
	}
	

	@RequestMapping(value = "/uploadResumeSubmit", method = RequestMethod.POST)
	public ModelAndView uploadPhoto(HttpServletRequest request, Applicant applicant){
		HttpSession session = request.getSession();
		try {
			File directory;
			String path = "C:\\Spring Projects\\JobsNinja\\src\\main\\webapp\\resources\\images";
			directory = new File(path + "\\");
			boolean temp = directory.exists();
			if (!temp) {
				temp = directory.mkdir();
			}
			if (temp) {
				
				CommonsMultipartFile photoInMemory = applicant.getPhoto();
				String fileName = photoInMemory.getOriginalFilename();
				File localFile = new File(directory.getPath(), fileName);
				photoInMemory.transferTo(localFile);
				applicant.setFilename(localFile.getName());
				System.out.println("File is stored at" + localFile.getPath());
				Applicant a = (Applicant)session.getAttribute("applicant");
				int applicantID=a.getId();
				
				applicantDao.uploadPhoto(applicantID, applicant.getFilename());
			} else {
				System.out.println("Directory not created");
			}
		

	}catch (IllegalStateException e) {
		System.out.println("* IllegalStateException: " + e.getMessage());
	} catch (IOException e) {
		System.out.println("* IOException: " + e.getMessage());
	} catch (Exception e) {
		e.printStackTrace();
	}
		
		return new ModelAndView("resumeUploaded","photoUploaded","success");
	}

	//Take the search criteria from front end and passes it to backend
	@RequestMapping(value = "/searchJobs", method = RequestMethod.GET)
	public ModelAndView searchJobs(Model model,HttpServletRequest request)
	{
		Applicant applicant=(Applicant) request.getSession().getAttribute("applicant");
		request.getSession().setAttribute("applicant", applicant);
		SearchJobFilter jobFilters= new SearchJobFilter();
		return new ModelAndView("jobListings","jobFilters", jobFilters);
	}
	
	//Renders job listings
	@RequestMapping(value = "/searchJobSubmit", method = RequestMethod.POST)
	public ModelAndView applicantViewJobsSubmit(Model model,SearchJobFilter jobFilters,HttpServletRequest request) throws Exception
	{
		Applicant applicant=(Applicant) request.getSession().getAttribute("applicant");
		applicant.setRole("Applicant");
		request.getSession().setAttribute("applicant", applicant);
		model.addAttribute("jobFilters",jobFilters);
		ArrayList<Job> jobs= applicantDao.searchJobsByCriteria(jobFilters);
		return new ModelAndView("jobListings","jobs",jobs);
	}

}
