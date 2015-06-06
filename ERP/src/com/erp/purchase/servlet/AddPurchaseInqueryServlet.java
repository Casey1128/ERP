package com.erp.purchase.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.purchase.entity.PurchaseInquery;
import com.erp.purchase.service.PurchaseInqueryService;
import com.erp.purchase.service.impl.PurchaseInqueryServiceImpl;

public class AddPurchaseInqueryServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddPurchaseInqueryServlet() {
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
		int ret=0;
		String code=request.getParameter("ainquerycode");
		String date=request.getParameter("ainquerydate");
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		PurchaseInqueryService purchaseInqueryService=new PurchaseInqueryServiceImpl();
		Date rDate=new Date();
		try {
			rDate=sdf.parse(date);
			String supplier=request.getParameter("ainquerysupplier");
			String adduser=request.getParameter("ainqueryadduser");
			String telphone=request.getParameter("ainquerytelphone");
			String fax=request.getParameter("ainqueryfax");
			String remarks=request.getParameter("ainqueryremarks");
			PurchaseInquery purchaseInquery=new PurchaseInquery();
			purchaseInquery.setCode(code);
			purchaseInquery.setAddDate(rDate);
			purchaseInquery.setSupplierCode(supplier);
			purchaseInquery.setAddUser(adduser);
			purchaseInquery.setTelPhone(telphone);
			purchaseInquery.setFax(fax);
			purchaseInquery.setRemarks(remarks);
			ret=purchaseInqueryService.add(purchaseInquery);
			if(ret==1){
				System.out.println("添加成功！");
				response.sendRedirect("/ERP/purchase/SearchPurchaseInqueryServlet");
			}else{
				System.out.println("添加失败!");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
