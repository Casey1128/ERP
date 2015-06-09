package com.erp.sale.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.sale.entity.saleOrder;
import com.erp.sale.service.orderService;
import com.erp.sale.service.impl.orderServiceImpl;

public class orderAddUpdateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public orderAddUpdateServlet() {
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
		this.doPost(request, response);
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
	private orderService order=new orderServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String code=request.getParameter("codes");
		String orderTime=request.getParameter("otime");
		
		SimpleDateFormat sdfDateFormat=new SimpleDateFormat("MM/dd/yyyy");
		Date orderDate=new Date();
		if(orderTime==null||orderTime.equals("")){
			orderDate=null;
		}else{
			try {
				orderDate=sdfDateFormat.parse(orderTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String customercode=request.getParameter("customercode");
		String state=request.getParameterValues("state")[0];
		String contacter=request.getParameter("contacter");
		String telphone=request.getParameter("telphone");
		String fax=request.getParameter("fax");
		String trans=request.getParameter("trans");
		String businesser=request.getParameter("businesser");
		String deliveryTime=request.getParameter("dtime");
		
		Date deliverydate=new Date();
		if(deliveryTime==null||deliveryTime.equals("")){
			deliverydate=null;
		}else{
			try {
				deliverydate=sdfDateFormat.parse(deliveryTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String nums=request.getParameter("nums");
		String numsprice=request.getParameter("numsprice");
		String adduser=request.getParameter("adduser");
		String remarks=request.getParameter("remarks");
		String opt=request.getParameter("opt");
		saleOrder saleorder=new saleOrder();
		saleorder.setCode(code);
		saleorder.setOrderDate(orderDate);
		saleorder.setCustomercode(customercode);
		saleorder.setState(state);
		saleorder.setContacter(contacter);
		saleorder.setTelphone(telphone);
		saleorder.setFax(fax);
		saleorder.setTrans(trans);
		saleorder.setBusinesser(businesser);
		saleorder.setDeliveryDate(deliverydate);
		saleorder.setNums(Integer.parseInt(nums));
		saleorder.setNumsPrice(Double.parseDouble(numsprice));
		
		if(opt.equals("1")){
			int ret=order.insert(saleorder);
		}else{//ÐÞ¸Ä
			
		}
		response.sendRedirect("../erpSystem/orderManagement.jsp"); 
		
		
	}

}
