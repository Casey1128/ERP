package com.erp.basic.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.basic.service.BaseContentService;
import com.erp.basic.service.impl.BaseContentServiceImpl;

public class DeleteSelectContentServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeleteSelectContentServlet() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	private BaseContentService baseContentService=new BaseContentServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String ids=request.getParameter("ids");
		String total[]=ids.split(",");
		int ret=0;
		for(int i=0;i<total.length;i++){
			String one[]=total[i].split("-");
			ret+=baseContentService.del(one[0], one[1]);
		}
		System.out.println(ret);
		response.sendRedirect("/ERP/SearchBaseContentServlet");
		
	}

}
