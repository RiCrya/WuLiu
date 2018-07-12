package com.ricrya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricrya.entity.Company;
import com.ricrya.entity.Parcel;
import com.ricrya.entity.Site;
import com.ricrya.service.CompanyService;
import com.ricrya.service.SiteService;
import com.ricrya.service.impl.CompanyServiceImpl;
import com.ricrya.service.impl.SiteServiceImpl;

import net.sf.json.JSONObject;

public class CompanyServlet extends HttpServlet {
	
	CompanyService cs = new CompanyServiceImpl();
	SiteService ss = new SiteServiceImpl();


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("list".equals(method)) {
			list(request, response);
		}if ("delete".equals(method)) {
			delete(request, response);
		}if ("add".equals(method)) {
			add(request, response);
		}if ("getSite".equals(method)) {
			getSite(request, response);
		}if ("update".equals(method)) {
			update(request, response);
		}if ("search".equals(method)) {
			search(request, response);
		}
		if ("searchPrice".equals(method)) {
			searchPrice(request, response);
		}
	}


	private void searchPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String start = request.getParameter("startSite");
		String end = request.getParameter("endSite");
		String type = request.getParameter("type");
		List<Company> list = cs.priceSearch(Integer.parseInt(start),Integer.parseInt(end),Integer.parseInt(type));
		request.setAttribute("list", list);
		request.getRequestDispatcher("qPage/companySearch.jsp").forward(request, response);
		
	}


	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("name");
		String name1 = "%"+name+"%";
		List<Company> list = cs.search(name1,name1,name1,name1,name1);
		request.setAttribute("list", list);
		request.getRequestDispatcher("page/expressList.jsp").forward(request, response);
		
	}


	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		String name = request.getParameter("companyName");
		String start = request.getParameter("startSite");
		String end = request.getParameter("endSite");
		String type = request.getParameter("type");
		String price = request.getParameter("price");
		System.out.println(name);
		System.out.println(start);
		System.out.println(end);
		System.out.println(type);
		System.out.println(price);
		cs.update(name,Integer.parseInt(start),Integer.parseInt(end),Integer.parseInt(type),Double.parseDouble(price),Integer.parseInt(id));
		list(request, response);
	}


	private void getSite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Site> list = ss.getAll();
		JSONObject json = new JSONObject();
		json.put("list", list);
		response.getWriter().write(json.toString());
		
	}


	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("companyName");
		String start = request.getParameter("startSite");
		String end = request.getParameter("endSite");
		String type = request.getParameter("type");
		String price = request.getParameter("price");
		
		cs.add(name,Integer.parseInt(start),Integer.parseInt(end),Integer.parseInt(type),Double.parseDouble(price));
		list(request, response);
	}


	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		cs.detele(Integer.parseInt(id));
		list(request, response);
		
	}


	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Company> list = cs.getAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("page/companyList.jsp").forward(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);

	}

}
