package com.erp.sale.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.basic.entity.basecusTomerSipplier;
import com.erp.sale.entity.saleQuotation;
import com.erp.utils.UnitCode;

public class addSaleQuotationServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public addSaleQuotationServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hids=request.getParameter("hid");
		UnitCode uc=new UnitCode();
	    String code= uc.getQuotationCode();
	    Date date=new Date();
	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time=sdf.format(date);
		
		//basecusTomerSipplier bSipplier=new basecusTomerSipplier();
		saleQuotation saleQuotation=new saleQuotation();
		saleQuotation.setCode(code);
		
		List<saleQuotation> list=new ArrayList<saleQuotation>();
		list.add(saleQuotation);
		request.setAttribute("list",list);
		
		request.getRequestDispatcher("/sale/addQuotation.jsp?hids="+hids).forward(request, response);

		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		
	}

}
