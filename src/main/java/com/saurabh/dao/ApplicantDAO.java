package com.saurabh.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import com.saurabh.pojo.Applicant;
import com.saurabh.pojo.Application;
import com.saurabh.pojo.Employer;
import com.saurabh.pojo.Job;
import com.saurabh.pojo.SearchJobFilter;
import com.saurabh.pojo.User;

public class ApplicantDAO extends DAO {

	
	public Applicant getApplicant(String name, String password)
            throws Exception {
        try {
            Criteria cr = getSession().createCriteria(Applicant.class);
	        cr.add(Restrictions.like("emailId", name));
	        cr.add(Restrictions.like("password", password));
	        Applicant applicant=(Applicant)cr.uniqueResult();
            return applicant;
        } catch (HibernateException e) {
        	close();
            throw new Exception("Applicant not found " + name, e);
        }
    }
	
	public Job getJobsById(int id) throws Exception
	{
		try {
            Criteria cr = getSession().createCriteria(Job.class);
            cr.add(Restrictions.eq("id", id));
            Job job=(Job)cr.uniqueResult();
            return job;
        } catch (HibernateException e) {
            throw new Exception("Job not found ", e);
        }
	}
	
	public void uploadPhoto(int applicantID, String filename) {
		try {
			getSession().getTransaction().begin();
			Query q = getSession().createQuery("update Applicant set filename = :filename where user_Id = :applicantID");
			q.setString("filename", filename);
			q.setLong("applicantID", applicantID);
			int result = q.executeUpdate();
			getSession().getTransaction().commit();
		} catch (HibernateException e) {
			rollback();
		}
	}
	
	
	public boolean saveApplication(Application application)
	{
		try{
			getSession().getTransaction().begin();
			getSession().saveOrUpdate(application);
			System.out.println("Application submittted");
			getSession().getTransaction().commit();
			return true;
		}
		catch(Exception ex)
		{
			getSession().getTransaction().rollback();
			return false;
		}
	}
	
	public ArrayList<Job> searchJobsByCriteria(SearchJobFilter jobFilters) throws Exception
	{
		
		try{
			String query;
			query= "From Job where jobTitle like :jobTitle";
			if(!jobFilters.getdescription().equalsIgnoreCase(""))
			{
				query=query+" And description=:description";
			}
			Query q = getSession().createQuery(query);
			q.setString("jobTitle",jobFilters.getJobTitle()+"%");
			if(!jobFilters.getdescription().equalsIgnoreCase(""))
			{
				q.setString("description",jobFilters.getdescription()+"%");
			}
			
            
            ArrayList<Job> jobs=(ArrayList<Job>)q.list();
            return jobs;
		}
		catch(Exception e)
		{
			throw new Exception("Could not get Job Details ", e);
		}
		
	}
	
}
