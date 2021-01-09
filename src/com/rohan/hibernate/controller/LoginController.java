package com.rohan.hibernate.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rohan.hibernate.dao.loginDAO;
import com.rohan.hibernate.dao.loginDaoImpl;
import com.rohan.hibernate.model.authen;

//import com.rohan.model.Login;


//@WebServlet(name = "LoginControllers", urlPatterns = { "/LoginControllers" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	loginDAO loginDAO=null;
    
    public LoginController() {
       
        loginDAO=new loginDaoImpl();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		authen login=new authen();
		login.setEmail(email);
		login.setPassword(password);
		
		String status=loginDAO.authenticate(login);
		if(status.equals("true")) {
	        session.setAttribute("email", login.getEmail());	
			response.sendRedirect("UserController?action=LIST");
		}
		
		if(status.equals("false")) {
			response.sendRedirect("index.jsp?status=false");
		}
		
		if(status.equals("error")) {
			response.sendRedirect("index.jsp?status=error");
		}
		
	}

}
