package com.saurabh.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import com.saurabh.pojo.Employer;
import com.saurabh.pojo.Job;
import com.saurabh.pojo.User;

public class EmployerDAO extends DAO {

	public boolean saveUser(User user)
	{
		try{
			getSession().getTransaction().begin();
			getSession().saveOrUpdate(user);
			getSession().getTransaction().commit();
			return true;
		}
		catch(Exception ex)
		{
			getSession().getTransaction().rollback();
			return false;
		}
	}
	
	public Job getJob(int id) throws Exception
	{
		try {
            Criteria cr = getSession().createCriteria(Job.class);
            cr.add(Restrictions.like("id", id));
            Job job=(Job)cr.uniqueResult();
            return job;
        } catch (HibernateException e) {
            throw new Exception("Not found " + id, e);
        }
	}
	
	public boolean saveJob(Job job)
	{
		try{
			getSession().getTransaction().begin();
			getSession().saveOrUpdate(job);
			getSession().getTransaction().commit();
			return true;
		}
		catch(Exception ex)
		{
			getSession().getTransaction().rollback();
			return false;
		}
	}
	
	public Employer getEmployer(String name, String password)
            throws Exception {
        try {
            Criteria cr = getSession().createCriteria(Employer.class);
	        cr.add(Restrictions.like("emailId", name));
	        cr.add(Restrictions.like("password", password));
	        Employer employer=(Employer)cr.uniqueResult();
            return employer;
        } catch (HibernateException e) {
        	close();
            throw new Exception("Employer not found " + name, e);
        }
    }
	
	public ArrayList<Job> getAllJobs(Employer employer) throws Exception
	{		
			Query q = getSession().createQuery("From Job where employer=:employer");
            q.setEntity("employer",employer);
            ArrayList<Job> jobs=(ArrayList<Job>)q.list();
            return jobs;

	}

	
}
