package com.ricrya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricrya.entity.User;
import com.ricrya.service.UserService;
import com.ricrya.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	
	UserService us = new UserServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		User u = new User();
		u.setUserName(userName);
		u.setUserPassword(userPassword);
		user=us.getLogin(u);
		if(user == null){
			request.getRequestDispatcher("/login.jsp?error=nouser").forward(request, response);
		}
		if(!user.getUserPassword().equals(u.getUserPassword())){
			request.getRequestDispatcher("/login.jsp?error=passworderror").forward(request, response);
		}else{
			request.setAttribute("user", user);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
