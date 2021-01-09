package com.rohan.hibernate.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import javax.swing.text.html.HTMLDocument.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.rohan.hibernate.model.user;
import com.rohan.hibernate.utility.HibernateUtil;

public class userDAOImpl implements userDAO {

	@Override
	public List<user> get() {
		
		
		//get the varaibales
		Transaction transaction=null;
		List<user> list=null;
		user u=null;
		
		try {
			//get session
			Session session=HibernateUtil.getSessionFactory().openSession();
			
			//start transaction
			transaction=session.beginTransaction();
			
			//get user object
			Query q=session.createQuery("FROM user");
			list=(List<user>)q.list();
			
			//commit the transaction
			transaction.commit();
			
		}
				
		
		catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public boolean save(user u) {
		
		boolean flag=false;
		
		Transaction transaction=null;
		try {
			Session session=HibernateUtil.getSessionFactory().openSession();
			
			transaction=session.beginTransaction();
			
			session.save(u);
			
			transaction.commit();
			flag=true;
		}
		catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			
			e.printStackTrace();
		}
		
		return flag;
		
	}

	// 1st step for edit
	@SuppressWarnings("null")
	@Override
	public user get(int id) {
		
		Transaction transaction=null;
		user user=null;
		try {
			Session session=HibernateUtil.getSessionFactory().openSession();
			transaction=session.beginTransaction();
			
			user=session.get(user.class,id);
			
			transaction.commit();
			
		}
		catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		
		return user;
	}

	@Override
	public boolean update(user u) {
		
		boolean flag=false;
		Transaction transaction=null;
		
		try {
			Session session=HibernateUtil.getSessionFactory().openSession();
			
			String hql="UPDATE user set name=:n1, phone=:p1, email=:e1, country=:c1 WHERE id=:d1";
			
			Query q=session.createQuery(hql);
			q.setParameter("n1", u.getName());
			q.setParameter("p1", u.getPhone());
			q.setParameter("e1", u.getEmail());
			q.setParameter("c1", u.getCountry());
			q.setParameter("d1", u.getId());
			
			transaction=session.beginTransaction();
			
			int up=q.executeUpdate();
			if(up>0) {
				transaction.commit();
				flag=true;	
			}			
		}
		catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
		}
		
		return flag;
	}

	public boolean delete(int id) {
		
		boolean flag=false;
		Transaction transaction=null;
		user user=null;
		
		try {
			Session session=HibernateUtil.getSessionFactory().openSession();
			
			transaction=session.beginTransaction();
			
			user=session.get(user.class, id);
			if(user!=null) {
				session.delete(user);
			}
			
			transaction.commit();
			flag=true;
			
		}
		catch(Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		
		return flag;
	}

}
