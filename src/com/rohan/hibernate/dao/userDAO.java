package com.rohan.hibernate.dao;

import java.util.List;

import com.rohan.hibernate.model.user;

public interface userDAO {
	
	List <user> get();
	
	boolean save(user u);
	
	user get(int id);
	
	boolean update(user u);
	
	boolean delete(int id);

}
