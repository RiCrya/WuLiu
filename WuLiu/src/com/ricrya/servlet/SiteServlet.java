package com.ricrya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricrya.entity.Parcel;
import com.ricrya.entity.Site;
import com.ricrya.service.SiteService;
import com.ricrya.service.impl.SiteServiceImpl;

public class SiteServlet extends HttpServlet {
	
	SiteService ss = new SiteServiceImpl();

	
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
		}
	}


	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String name1 = "%"+name+"%";
		List<Site> list = ss.search(name1);
		request.setAttribute("list", list);
		request.getRequestDispatcher("page/siteList.jsp").forward(request, response);
		
	}


	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("site_name");
		ss.update(name,Integer.parseInt(id));
		list(request, response);
	}


	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("site_name");
		ss.add(name);
		list(request, response);
	}


	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		ss.detele(Integer.parseInt(id));
		list(request, response);
	}


	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Site> list = ss.getAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("page/siteList.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
