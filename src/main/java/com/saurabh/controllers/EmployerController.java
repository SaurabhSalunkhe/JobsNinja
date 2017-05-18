package com.saurabh.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.saurabh.dao.EmployerDAO;
import com.saurabh.dao.UserDAO;
import com.saurabh.pojo.Applicant;
import com.saurabh.pojo.Employer;
import com.saurabh.pojo.Job;
import com.saurabh.pojo.User;
import com.saurabh.utilities.EmailDetails;
import com.saurabh.utilities.EmailUtils;
import com.saurabh.validators.EmployerValidator;

@Controller
public class EmployerController {
	
	@Autowired
	private EmployerValidator employervalidator;
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private EmployerDAO employerDao;
	
	
	//passes an empty employer object and renders the employer sign up page
	@RequestMapping(value = "/employersignuppage", method = RequestMethod.GET)
	public ModelAndView employerSignUpPage(Model model)
	{
		return new ModelAndView("employerSignup","employer",new Employer());
	}
	
	
	//validate the employer via spring validators, then save the employer in db, renders the employerHomePage
	@RequestMapping(value = "/employerSignUpSubmit", method = RequestMethod.POST)
	public ModelAndView employerSignUpSubmit(Model model,Employer employer,HttpSession session,BindingResult result)
	{
		
		employervalidator.validate(employer, result);
		
		if(result.hasErrors()){
			return new ModelAndView("employerSignup");
		}
		session.setAttribute("employer", employer);
		employer.setRole("employer");
		userDao.saveUser(employer);
		return new ModelAndView("employerHomePage");
	}
	
	@RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
	public String sendEmail(Model model,HttpServletRequest request) throws Exception
	{
		int applicantId=Integer.parseInt(request.getParameter("applicantId"));
		Applicant applicant=(Applicant) userDao.getUserById(applicantId);
		User user= (User) request.getSession().getAttribute("employer");
		EmailDetails emailDetails= new EmailDetails();
		emailDetails.setFrom(user.getFirstName()+" "+user.getLastName());
		emailDetails.setToName(applicant.getFirstName()+" "+applicant.getLastName());
		emailDetails.setTo(applicant.getEmailId());
		model.addAttribute("emailDetails",emailDetails);
		return "sendEmail";
	}
	
	//syntax for viewing applicant resume in pdf format
	@RequestMapping(value = "/viewApplicantResume", method = RequestMethod.GET)
	public void viewPdfResume(Model model,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		int id=Integer.parseInt(request.getParameter("applicantId"));
		Applicant applicant= (Applicant) userDao.getUserById(id);
		File f= new File("C:\\Spring Projects\\JobsNinja\\src\\main\\webapp\\resources\\images\\"+applicant.getFilename());
		FileInputStream fis= new FileInputStream(f);
		response.setHeader("Expires", "0");
        response.setHeader("Pragma", "public");
        response.setHeader("Cache-Control","must-revalidate, post-check=0,precheck=0");
        response.setContentType("application/pdf");
        response.setContentLength((int) f.length());
        OutputStream os = response.getOutputStream();
        IOUtils.copy(fis, os);
        os.flush();
        os.close(); 
	}
	
//	Passes the employer object retrieved by session to the back end
	@RequestMapping(value = "/employerprofile", method = RequestMethod.GET)
	public ModelAndView applicantProfile(Model model,HttpServletRequest request) throws Exception
	{
		Employer employer=(Employer) request.getSession().getAttribute("employer");
		return new ModelAndView("employerProfile","employer",employer);
	}
	
	
	@RequestMapping(value = "/employerpostjob", method = RequestMethod.GET)
	public ModelAndView employerPostJob(Model model,Employer employer,HttpSession session)
	{
		Job job = new Job();
		return new ModelAndView("employerPostJob","job", job);
	}
	
	@RequestMapping(value = "/employerpostJobSubmit", method = RequestMethod.POST)
	public ModelAndView employerpostJobSubmit(Model model,Job job,HttpSession session)
	{		
		Employer employer = (Employer) session.getAttribute("employer");
		job.setEmployer(employer);
		employerDao.saveJob(job);
		return new ModelAndView("jobPosted");
	}
	
	@RequestMapping(value = "sendEmailSubmit", method = RequestMethod.POST)
	public String sendEmailSubmit(Model model,EmailDetails emailDetails,HttpServletRequest request) throws Exception
	{
		
		
		EmailUtils.sendApplicantMail(emailDetails);
		return "emailSentSuccessfully";
		
		
			
	}
	
	
	//employer vieweing job
	@RequestMapping(value = "/employerviewjobs", method = RequestMethod.GET)
	public ModelAndView employerviewjobs(Model model,HttpSession session) throws Exception {
		Employer employer=(Employer) session.getAttribute("employer");
		ArrayList<Job> jobs=employerDao.getAllJobs(employer);
		return new ModelAndView("employerViewingJob","jobs",jobs);
	}
	
	//views the applicant applications 
	@RequestMapping(value = "/viewApplicantApplications", method = RequestMethod.GET)
	public String employerviewjobApplicants(Model model,HttpSession session,HttpServletRequest request) throws Exception {
		Employer employer=(Employer) session.getAttribute("employer");
		int jobId=Integer.parseInt(request.getParameter("jobId"));
		Job job= employerDao.getJob(jobId);
		model.addAttribute("applications",job.getApplications());
		ArrayList<Job> jobs=employerDao.getAllJobs(employer);
		model.addAttribute("jobs",jobs);
		return "employerViewJobApplicants";
	}
}




