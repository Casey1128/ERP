package com.erp.purchase.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.purchase.service.PurchaseReturnService;
import com.erp.purchase.service.impl.PurchaseReturnServiceImpl;

public class DeleteSelectPurchaseReturnServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeleteSelectPurchaseReturnServlet() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	private PurchaseReturnService purchaseReturnService=new PurchaseReturnServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String ids=request.getParameter("ids");
		String total[]=ids.split(",");
		int ret=0;
		for(int i=0;i<total.length;i++){
			ret+=purchaseReturnService.del(total[i]);
		}
		System.out.println(ret);
		response.sendRedirect("/ERP/purchase/SearchPurchaseReturnServlet");
		
	}

}
