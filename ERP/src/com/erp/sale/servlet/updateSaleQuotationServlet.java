package com.erp.sale.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.basic.entity.basecusTomerSipplier;
import com.erp.sale.entity.saleQuotation;
import com.erp.sale.service.saleQuotationService;
import com.erp.sale.service.impl.saleQuotationServiceimpl;
import com.erp.utils.DateUtil;

public class updateSaleQuotationServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public updateSaleQuotationServlet() {
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
	private saleQuotationService saleQuotationService=new saleQuotationServiceimpl();
	private saleQuotation sQuotation=new saleQuotation();
	private basecusTomerSipplier pSipplier=new basecusTomerSipplier();
	private DateUtil dateUtil=new DateUtil();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String hidcode=request.getParameter("hid");
		String salecode=request.getParameter("salecode");
		String adddate=request.getParameter("adddate");
		String csName=request.getParameter("csName");
		String contacter=request.getParameter("contacter");
		String telphone=request.getParameter("telphone");
		String fax=request.getParameter("fax");
		String remarks=request.getParameter("remarks");
		
		sQuotation.setCode(salecode);
		Date addDate = null;
		try {
			addDate = dateUtil.toDate(adddate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sQuotation.setSqdate(new java.sql.Date(addDate.getTime()));
		pSipplier.setCsName(csName);
		sQuotation.setbSipplier(pSipplier);
		sQuotation.setContacter(contacter);
		sQuotation.setTelphone(telphone);
		sQuotation.setFax(fax);
		sQuotation.setRemarks(remarks);
		if(hidcode.equals("1")){
			int ret=saleQuotationService.insertQuotation(sQuotation);
		}	
		if(hidcode.equals("2")){
			int ret=saleQuotationService.updateQuotation(sQuotation);
		}
		response.sendRedirect("/ERP/sale/quotation.jsp");
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
