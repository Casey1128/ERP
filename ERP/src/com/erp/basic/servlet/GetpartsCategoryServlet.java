package com.erp.basic.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.erp.basic.entity.Baseparts;
import com.erp.basic.service.BasepartsService;
import com.erp.basic.service.impl.BasepartsServiceImpl;

public class GetpartsCategoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	private BasepartsService bs=new BasepartsServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String pageNo=request.getParameter("page");
		String pageSize=request.getParameter("rows");
		if(pageNo==null||pageNo==""){
			pageNo="1";
		}
		if(pageSize==null||pageSize==""){
			pageSize="3";
		}
		response.setContentType("text/json; charset=utf-8");
		List<Baseparts> list=bs.getCategoryBaseparts();
		JSONArray jsonArray=new JSONArray();
		//JSONObject jsonObject=new JSONObject();
		String data=jsonArray.fromObject(list).toString();
		System.out.println(data);		
		response.getWriter().println(data);
		
	}

}
