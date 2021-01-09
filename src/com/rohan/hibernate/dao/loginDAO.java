package com.rohan.hibernate.dao;

import com.rohan.hibernate.model.authen;

//import com.rohan.hibernate.model.Login;

public interface loginDAO {
	
	String authenticate(authen login);

}
