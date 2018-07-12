package com.ricrya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ricrya.entity.Parcel;
import com.ricrya.entity.Site;
import com.ricrya.entity.User;
import com.ricrya.service.UserService;
import com.ricrya.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	
	UserService us = new UserServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("list".equals(method)) {
			list(request, response);
		}if ("delete".equals(method)) {
			delete(request, response);
		}if ("add".equals(method)) {
			add(request, response);
		}if ("update".equals(method)) {
			update(request, response);
		}if ("search".equals(method)) {
			search(request, response);
		}if ("login".equals(method)) {
			login(request, response);
		}if ("logout".equals(method)) {
			logout(request, response);
		}
		
		
		
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("name");
		String name1 = "%"+name+"%";
		List<User> list = us.search(name1);
		request.setAttribute("list", list);
		request.getRequestDispatcher("page/adminList.jsp").forward(request, response);
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		String name = request.getParameter("userName");
		String password = request.getParameter("password");
		us.update(name,password,Integer.parseInt(id));
		list(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("userName");
		String password = request.getParameter("password");
		us.add(name,password);
		list(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		us.detele(Integer.parseInt(id));
		list(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<User> list = us.getAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("page/adminList.jsp").forward(request, response);
		
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		User user = new User();
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		User u = new User();
		u.setUserName(userName);
		u.setUserPassword(userPassword);
		user=us.getLogin(u);
		userName = user.getUserName();
		if(user == null){
			request.getRequestDispatcher("/login.jsp?error=nouser").forward(request, response);
		}
		if(!user.getUserPassword().equals(u.getUserPassword())){
			request.getRequestDispatcher("/login.jsp?error=passworderror").forward(request, response);
		}else{
			request.getSession().setAttribute("user", userName);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
