package com.erp.stock.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.stock.Tools.DateUtilSly;
import com.erp.stock.service.StockInService;
import com.erp.stock.service.Impl.StockInServiceImpl;

public class StockInAddServlet extends HttpServlet {

	public StockInAddServlet() {
		super();
	}

	StockInService stock=new StockInServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		DateUtilSly dus=new DateUtilSly();
		
		String opt=request.getParameter("opt");
		
		if(opt.equals("1")){
			String code=request.getParameter("code");
			String indate=request.getParameter("indate");
			indate=dus.toOracleString(dus.toDate(indate));

			String supplierCode=request.getParameter("supplierCode");
			String contacter=request.getParameter("contacter");
			String telephone=request.getParameter("telephone");
			String fax=request.getParameter("fax");
			String intypese=request.getParameter("intypese");
			String intypere=request.getParameter("intypere");
			if(intypere.equals("0")){intypere="正常入库";}
			if(intypere.equals("1")){intypere="冲抵入库";}
			String intype=intypese+"-"+intypere;
			String isinvoice=request.getParameter("isinvoice");
			String remarks=request.getParameter("remarks");
			
			Object[] obj=new Object[]{code,indate,supplierCode,contacter,telephone,fax,intype,isinvoice,remarks};
			
			int ret=stock.addDataStIn(obj);
			response.sendRedirect("/ERP/erpStock/StockIn/StockInAdd.jsp");
			
			
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}