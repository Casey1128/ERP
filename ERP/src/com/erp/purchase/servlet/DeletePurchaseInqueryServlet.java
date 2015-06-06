package com.erp.purchase.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.purchase.service.PurchaseInqueryService;
import com.erp.purchase.service.impl.PurchaseInqueryServiceImpl;

public class DeletePurchaseInqueryServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeletePurchaseInqueryServlet() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PurchaseInqueryService purchaseInqueryService=new PurchaseInqueryServiceImpl();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String code=request.getParameter("code");
		System.out.println(code+"----");
		int ret=0;
		ret=purchaseInqueryService.del(code);
		response.getWriter().println(ret);
	}

}
