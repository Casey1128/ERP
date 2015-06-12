package com.erp.sale.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.sale.service.SaleReturnService;
import com.erp.sale.service.impl.SaleReturnServiceImpl;

public class DelSaleReturnServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	private SaleReturnService srs=new SaleReturnServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String code=request.getParameter("code");
		int ret=srs.delSaleReturn(code);
		System.out.println(ret);
		response.getWriter().println(ret);
	}

}
