package com.rohan.hibernate.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rohan.hibernate.dao.userDAO;
import com.rohan.hibernate.dao.userDAOImpl;
import com.rohan.hibernate.model.user;



public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	RequestDispatcher rd=null;
	userDAO userdao=null;
	
    public UserController() {
        
        userdao=new userDAOImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getParameter("action");
		
		if(action==null) {
			action="LIST";
		}
		
		switch(action) {
		case "LIST":
			listUser(request,response);
			break;
			
		case "EDIT":
		    getSingleUser(request,response);
		    break;
		    
		case "DELETE":
			deleteUser(request,response);
			break;
			
			default:
				listUser(request,response);
				break;
		
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		
		user user=new user();
		
		user.setName(name);
		user.setPhone(phone);
		user.setEmail(email);
		user.setCountry(country);
		
		if(id==null || id.isEmpty()) {
		
		if(userdao.save(user)) {
			request.setAttribute("message", "Saved successfully!!");
		 }
		}
		else {
		user.setId(Integer.parseInt(id));	
			if(userdao.update(user)) {
				request.setAttribute("message", "Updated successfully!!");
			}
			
		}
		
		listUser(request,response);
		
	}
	
	
	public void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
        List<user> list= userdao.get();
		request.setAttribute("list", list);
		rd=request.getRequestDispatcher("/views/list.jsp");
		rd.forward(request, response);
		
	}
	
	public void getSingleUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id=request.getParameter("id");
		user user=userdao.get(Integer.parseInt(id));
		
		request.setAttribute("user", user);
		
		rd=request.getRequestDispatcher("/views/add.jsp");
		rd.forward(request, response);
		
	}
	
	public void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String id=request.getParameter("id");
		if(userdao.delete(Integer.parseInt(id))) {
			request.setAttribute("message", "Deleted successfully!!");
		}
		
		listUser(request,response);
		
	}
}
	
