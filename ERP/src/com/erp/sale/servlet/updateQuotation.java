package com.erp.sale.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.basic.entity.basecusTomerSipplier;
import com.erp.sale.entity.saleQuotation;
import com.erp.sale.service.saleQuotationService;
import com.erp.sale.service.impl.saleQuotationServiceimpl;

public class updateQuotation extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public updateQuotation() {
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
	private saleQuotationService saleQuotationService=new saleQuotationServiceimpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String code=request.getParameter("code");
		String hids=request.getParameter("hid");
		//basecusTomerSipplier supplier=new basecusTomerSipplier();
		saleQuotation sQuotation=new saleQuotation();
		sQuotation=saleQuotationService.searchQuotation(code);
		List<saleQuotation> list=new ArrayList<saleQuotation>();
		list.add(sQuotation);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/sale/addQuotation.jsp?hids="+hids).forward(request, response); 
		
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
