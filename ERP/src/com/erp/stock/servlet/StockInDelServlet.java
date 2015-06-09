package com.erp.stock.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.stock.service.StockInService;
import com.erp.stock.service.Impl.StockInServiceImpl;

public class StockInDelServlet extends HttpServlet {


	public StockInDelServlet() {
		super();
	}

	StockInService stock=new StockInServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String opts=request.getParameter("opt");
		if(opts.equals("1")){//单个删除
			String code=request.getParameter("code");
			int ret=stock.delDataStIn(code);
			response.sendRedirect("/ERP/erpStock/StockIn/StockIn.jsp");	
		}
		if(opts.equals("2")){//批量删除
			String ss=request.getParameter("deleteallrows");
			String[] incode=ss.split(",");
			for (int i=0;i<incode.length;i++){
				int ret=stock.delDataStIn(incode[i]);
			}	
			response.sendRedirect("/ERP/erpStock/StockIn/StockIn.jsp");	
		}

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}