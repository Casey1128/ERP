package com.erp.purchase.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.purchase.service.PurchaseReturnService;
import com.erp.purchase.service.impl.PurchaseReturnServiceImpl;

public class DeletePurchaseReturnServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeletePurchaseReturnServlet() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PurchaseReturnService purchaseReturnService=new PurchaseReturnServiceImpl();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String code=request.getParameter("code");
		System.out.println(code+"----");
		int ret=0;
		ret=purchaseReturnService.del(code);
		response.getWriter().println(ret);
	}

}
