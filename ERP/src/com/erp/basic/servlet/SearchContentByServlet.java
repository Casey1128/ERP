package com.erp.basic.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.erp.basic.entity.BaseContent;
import com.erp.basic.service.BaseContentService;
import com.erp.basic.service.impl.BaseContentServiceImpl;

public class SearchContentByServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SearchContentByServlet() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String code=request.getParameter("code");
		String category=request.getParameter("category");
		BaseContent baseContent=new BaseContent();
		
		BaseContentService baseContentService=new BaseContentServiceImpl();
		baseContent=baseContentService.findByCaCode(category, code);
		JSONObject obj=new JSONObject();
		obj=JSONObject.fromObject(baseContent);
		String data=obj.toString();
		System.out.println(data);
		response.getWriter().println(data);
	
	}

}
