package com.rohan.hibernate.utility;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.rohan.hibernate.model.authen;
import com.rohan.hibernate.model.user;

public class HibernateUtil {
	
	private static SessionFactory sessionfactory=null;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionfactory==null) {
			
			try {
				
				Configuration configuration =new Configuration();
				
				Properties prop=new Properties();
				prop.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
				prop.put(Environment.URL,"jdbc:mysql://localhost:3306/demo2?useSSL=false");
				prop.put(Environment.USER,"root");
				prop.put(Environment.PASS,"Ramesh@1994");
				prop.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
				prop.put(Environment.SHOW_SQL,"true");
				prop.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
				//prop.put(Environment.HBM2DDL_AUTO,"create-drop");

				
				configuration.setProperties(prop);
				configuration.addAnnotatedClass(user.class);
				configuration.addAnnotatedClass(authen.class);
				
				ServiceRegistry service=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				sessionfactory=configuration.buildSessionFactory(service);
				return sessionfactory;
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		return sessionfactory;
	}

}
