package com.erp.basic.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.basic.service.UnitService;
import com.erp.basic.service.impl.UnitServiceImpl;

public class DeleteSelectUnitServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeleteSelectUnitServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private UnitService unitService=new UnitServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//basecusTomerSipplier bSipplier=new basecusTomerSipplier();
		response.setContentType("text/json; charset=utf-8");
		String code=request.getParameter("code");
		
		
		int ret =unitService.deleteUnit(code);
		  
        response.getWriter().println(ret);
		//response.sendRedirect("/ERP/Unit/unitIndex.jsp");
	}

}
