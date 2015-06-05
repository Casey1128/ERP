package com.erp.basic.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.basic.entity.basecusTomerSipplier;
import com.erp.basic.service.UnitService;
import com.erp.basic.service.impl.UnitServiceImpl;

public class updateUnitServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public updateUnitServlet() {
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
	private UnitService unitService=new UnitServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code=request.getParameter("code");
		basecusTomerSipplier supplier=new basecusTomerSipplier();
		supplier=unitService.findBaseCustomerSupplier(code);
		List<basecusTomerSipplier> list=new ArrayList<basecusTomerSipplier>();
		list.add(supplier);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/Unit/addUnit.jsp").forward(request, response); 
		
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
