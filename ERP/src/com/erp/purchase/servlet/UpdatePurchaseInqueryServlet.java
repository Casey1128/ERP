package com.erp.purchase.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.purchase.entity.PurchaseInquery;
import com.erp.purchase.service.PurchaseInqueryService;
import com.erp.purchase.service.impl.PurchaseInqueryServiceImpl;

public class UpdatePurchaseInqueryServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdatePurchaseInqueryServlet() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String code=request.getParameter("inquerycode");
		String supplier=request.getParameter("inquerysupplier");
		String adduser=request.getParameter("inqueryadduser");
		String telphone=request.getParameter("inquerytelphone");
		String fax=request.getParameter("inqueryfax");
		String remarks=request.getParameter("inqueryremarks");
		PurchaseInquery purchaseInquery=new PurchaseInquery();
		PurchaseInqueryService purchaseInqueryService=new PurchaseInqueryServiceImpl();
		int ret=0;
		try {
			purchaseInquery.setCode(code);
			purchaseInquery.setSupplierCode(supplier);
			purchaseInquery.setAddUser(adduser);
			purchaseInquery.setTelPhone(telphone);
			purchaseInquery.setFax(fax);
			purchaseInquery.setRemarks(remarks);
			ret=purchaseInqueryService.update(purchaseInquery);
			if(ret>0){
				System.out.println("更新成功！");
				response.sendRedirect("/ERP/purchase/SearchPurchaseInqueryServlet");
			}else{
				System.out.println("更新失败!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
