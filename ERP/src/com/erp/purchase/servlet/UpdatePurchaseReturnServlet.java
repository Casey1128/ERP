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

public class UpdatePurchaseReturnServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdatePurchaseReturnServlet() {
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
		String code=request.getParameter("returncode");
		String supplier=request.getParameter("returnsupplier");
		String adduser=request.getParameter("returnadduser");
		String telphone=request.getParameter("returntelphone");
		String fax=request.getParameter("returnfax");
		String remarks=request.getParameter("returnremarks");
		PurchaseReturn purchaseReturn=new PurchaseReturn();
		PurchaseReturnService purchaseReturnService=new PurchaseReturnServiceImpl();
		int ret=0;
		try {
			purchaseReturn.setCode(code);
			purchaseReturn.setSupplierCode(supplier);
			purchaseReturn.setAddUser(adduser);
			purchaseReturn.setTelPhone(telphone);
			purchaseReturn.setFax(fax);
			purchaseReturn.setRemarks(remarks);
			ret=purchaseReturnService.update(purchaseReturn);
			if(ret>0){
				System.out.println("更新成功！");
				response.sendRedirect("/ERP/purchase/SearchPurchaseReturnServlet");
			}else{
				System.out.println("更新失败!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
