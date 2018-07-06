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
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		User u = new User();
		u.setUserName(userName);
		u.setUserPassword(userPassword);
		us.login(u);
		if (u!= null){
             response.getWriter().write(u.toString());
        }else {
             response.getWriter().write("sorry, your username or password is wrong!");
        }
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
