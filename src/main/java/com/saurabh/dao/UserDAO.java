package com.saurabh.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.saurabh.pojo.User;

public class UserDAO extends DAO {

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
	
	public boolean checkUserExists(String name)
            throws Exception {
        try {
            Criteria cr = getSession().createCriteria(User.class);
	        cr.add(Restrictions.like("emailId", name.trim()));
	        User user=(User) cr.uniqueResult();
	        if(user!=null)
	        {
	        	return true;
	        }
	        else
	        {
	        	return false;
	        }
        } catch (HibernateException e) {
        	close();
            throw new Exception("User Not found " + name, e);
        }
    }
	
	public User getUserById(int id)
            throws Exception {
        try {
            Criteria cr = getSession().createCriteria(User.class);
            cr.add(Restrictions.like("id", id));
	        User user=(User)cr.uniqueResult();
            return user;
        } catch (HibernateException e) {
        	close();
            throw new Exception("User not found " + id, e);
        }
    }
	
}
