package com.rohan.hibernate.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.rohan.hibernate.model.user;
import com.rohan.hibernate.utility.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		/*
		session.beginTransaction();
		
	user u2=new user();
	u2.setName("rohank");
	u2.setPhone("1234569899");
	u2.setEmail("rohan1@gmail.com");
	u2.setCountry("canada");
	
	session.save(u2);
	
	session.getTransaction().commit();
	session.close();
	*/
		
		List l=session.createQuery("from user").list();
		System.out.println(l.size());
	
		}
		
	}


