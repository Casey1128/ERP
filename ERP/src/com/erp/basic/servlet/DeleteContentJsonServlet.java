package com.erp.basic.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.basic.service.BaseContentService;
import com.erp.basic.service.impl.BaseContentServiceImpl;

public class DeleteContentJsonServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeleteContentJsonServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	private BaseContentService baseContentService=new BaseContentServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String code=request.getParameter("code");
		String category=request.getParameter("category");
		System.out.println(code+"----"+category);
		int ret=0;
		ret=baseContentService.del(code,category);
		response.getWriter().println(ret);
	}

}
