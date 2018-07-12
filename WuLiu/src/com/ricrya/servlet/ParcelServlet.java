package com.ricrya.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricrya.entity.Parcel;
import com.ricrya.entity.Site;
import com.ricrya.service.ParcelService;
import com.ricrya.service.SiteService;
import com.ricrya.service.impl.ParcelServiceImpl;
import com.ricrya.service.impl.SiteServiceImpl;

import net.sf.json.JSONObject;

public class ParcelServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ParcelService pkgs = new ParcelServiceImpl();
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
		}if ("page".equals(method)) {
			page(request, response);
		}if ("searchList".equals(method)) {
			searchList(request, response);
		}
	}
	
	private void searchList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String number = request.getParameter("number");
		List<Parcel> list  = pkgs.searchList(number);
		request.setAttribute("list", list);
		request.getRequestDispatcher("qPage/expressSearch.jsp").forward(request, response);
	}

	private void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String pageObj = request.getParameter("page");
		Integer page = 1;
		try {
            page = Integer.parseInt(pageObj);
        } catch (Exception e) {
        }
		
		int count = pkgs.page();
		int totalPages = count/2 + 1;
		
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("currentPage", page);
	}
	

	private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String name = request.getParameter("name");
		String name1 = "%"+name+"%";
		List<Parcel> list = pkgs.search(name1,name1,name1,name1,name1,name1,name1,name1);
		request.setAttribute("list", list);
		request.getRequestDispatcher("page/expressList.jsp").forward(request, response);
		
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String id = request.getParameter("id");
		String number = request.getParameter("pkg_number");
		String start = request.getParameter("startSite");
		String end = request.getParameter("endSite");
		String type = request.getParameter("pkg_type");
		String sender = request.getParameter("sender");
		String senderPhone = request.getParameter("sender_phone");
		String recipient = request.getParameter("recipient");
		String recipientPhone = request.getParameter("recipient_phone");
		pkgs.update(number,Integer.parseInt(start),Integer.parseInt(end),Integer.parseInt(type),sender,senderPhone,recipient,recipientPhone,Integer.parseInt(id));
		list(request, response);
	}

	private void getSite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Site> list = ss.getAll();
		JSONObject json = new JSONObject();
		json.put("list", list);
		response.getWriter().write(json.toString());
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number = request.getParameter("pkg_number");
		String start = request.getParameter("startSite");
		String end = request.getParameter("endSite");
		String type = request.getParameter("pkg_type");
		String sender = request.getParameter("sender");
		String senderPhone = request.getParameter("sender_phone");
		String recipient = request.getParameter("recipient");
		String recipientPhone = request.getParameter("recipient_phone");
		pkgs.add(number,Integer.parseInt(start),Integer.parseInt(end),Integer.parseInt(type),sender,senderPhone,recipient,recipientPhone);
		list(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		pkgs.detele(Integer.parseInt(id));
		list(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Parcel> list = pkgs.getAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("page/expressList.jsp").forward(request, response);
	}
	
	


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
