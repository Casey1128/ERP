package com.erp.sale.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.sale.entity.SaleReturn;
import com.erp.sale.service.SaleReturnService;
import com.erp.sale.service.impl.SaleReturnServiceImpl;
import com.erp.utils.DateUtil;

public class UpdateSaleReturnServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	private SaleReturnService srs=new SaleReturnServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String opt=request.getParameter("opt");
		String code=request.getParameter("code");
		String xtDate=request.getParameter("xtDate");
		String customerCode=request.getParameter("customerCode");
		String contacter=request.getParameter("contacter");
		String telphone=request.getParameter("telphone");
		String fax=request.getParameter("fax");
		String remarks=request.getParameter("remarks");
		DateUtil dateUtil=new DateUtil();
		
		if(opt!=null&&opt.equals("1")){
			//1Ìí¼Ó
			SaleReturn sr=new SaleReturn();
			sr.setCode(code);
			try {
				sr.setXtDate(new java.sql.Date(dateUtil.toDate(xtDate).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			sr.setCustomerCode(customerCode);	
			sr.setContacter(contacter);
			sr.setTelphone(telphone);
			sr.setFax(fax);
			sr.setRemarks(remarks);
			int date=srs.addSaleReturn(sr);
			
			
			System.out.println(date);
			
		}else{
			SaleReturn sr=new SaleReturn();
			sr.setCode(code);
			try {
				sr.setXtDate(new java.sql.Date(dateUtil.toDate(xtDate).getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sr.setCustomerCode(customerCode);
			sr.setContacter(contacter);
			sr.setTelphone(telphone);
			sr.setFax(fax);
			sr.setRemarks(remarks);
			srs.updateSaleReturn(sr);
			
		}
		response.sendRedirect("/ERP/erpSystem/SaleReturnManagement.jsp");
	}

}
