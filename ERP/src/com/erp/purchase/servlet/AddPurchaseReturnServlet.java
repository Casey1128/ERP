package com.erp.purchase.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.purchase.entity.PurchaseReturn;
import com.erp.purchase.service.PurchaseReturnService;
import com.erp.purchase.service.impl.PurchaseReturnServiceImpl;

public class AddPurchaseReturnServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddPurchaseReturnServlet() {
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
		String returncode=request.getParameter("areturncode");
		String retrundate=request.getParameter("areturndate");
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		PurchaseReturnService purchaseReturnService=new PurchaseReturnServiceImpl();
		Date rDate=new Date();
		try {
			rDate=sdf.parse(retrundate);
			String returnsupplier=request.getParameter("areturnsupplier");
			String returnadduser=request.getParameter("areturnadduser");
			String returntelphone=request.getParameter("areturntelphone");
			String returnfax=request.getParameter("areturnfax");
			String returnremarks=request.getParameter("areturnremarks");
			PurchaseReturn purchaseReturn=new PurchaseReturn();
			purchaseReturn.setCode(returncode);
			purchaseReturn.setrDate(rDate);
			purchaseReturn.setSupplierCode(returnsupplier);
			purchaseReturn.setAddUser(returnadduser);
			purchaseReturn.setTelPhone(returntelphone);
			purchaseReturn.setFax(returnfax);
			purchaseReturn.setRemarks(returnremarks);
			ret=purchaseReturnService.add(purchaseReturn);
			if(ret==1){
				System.out.println("添加成功！");
				response.sendRedirect("/ERP/purchase/SearchPurchaseReturnServlet");
			}else{
				System.out.println("添加失败!");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
