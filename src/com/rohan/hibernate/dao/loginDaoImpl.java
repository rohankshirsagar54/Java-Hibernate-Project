package com.rohan.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

//import com.rohan.hibernate.model.Login;
import com.rohan.hibernate.model.authen;
import com.rohan.hibernate.utility.HibernateUtil;

public class loginDaoImpl implements loginDAO {

	@Override
	public String authenticate(authen login) {
		
		Transaction transaction=null;
		
		try {
			
			Session session=HibernateUtil.getSessionFactory().openSession();
			
			transaction=session.beginTransaction();
			
 Object o=session.createQuery("FROM authen WHERE email=:email and password=:password").setParameter("email", login.getEmail()).setParameter("password",login.getPassword()).uniqueResult();
			
if(o!=null) {
	transaction.commit();
	return "true";
}
else {
	return "false";
}		
			
		}
		catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			
			e.printStackTrace();
		}
		
		
		return "error";
	}

}
