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
		String opt=request.getParameter("opt");
		if(opt.equals("1")){
			String code=request.getParameter("code");
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
			String adduser=request.getParameter("addusers");
			String remarks=request.getParameter("remarks");
			saleOrder saleorder=new saleOrder();
			saleorder.setCode(code);
			saleorder.setOrderDate(orderDate);
			saleorder.setCustomercode(customercode);
			saleorder.setAddUser(adduser);
			saleorder.setState(state);
			saleorder.setContacter(contacter);
			saleorder.setTelphone(telphone);
			saleorder.setFax(fax);
			saleorder.setTrans(trans);
			saleorder.setBusinesser(businesser);
			saleorder.setDeliveryDate(deliverydate);
			saleorder.setNums(Integer.parseInt(nums));
			saleorder.setNumsPrice(Double.parseDouble(numsprice));
			int ret=order.insert(saleorder);
		}else if(opt.equals("2")){//ÐÞ¸Ä
			String code2=request.getParameter("code2");
			String orderTime2=request.getParameter("otime2");
			SimpleDateFormat sdfDateFormat2=new SimpleDateFormat("MM/dd/yyyy");
			Date orderDate2=new Date();
			if(orderTime2==null||orderTime2.equals("")){
				orderDate2=null;
			}else{
				try {
					orderDate2=sdfDateFormat2.parse(orderTime2);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			String customercode2=request.getParameter("customercode2");
			String state2=request.getParameterValues("state2")[0];
			String contacter2=request.getParameter("contacter2");
			String telphone2=request.getParameter("telphone2");
			String fax2=request.getParameter("fax2");
			String trans2=request.getParameter("trans2");
			String businesser2=request.getParameter("businesser2");
			String deliveryTime2=request.getParameter("dtime2");
			Date deliverydate2=new Date();
			if(deliveryTime2==null||deliveryTime2.equals("")){
				deliverydate2=null;
			}else{
				try {
					deliverydate2=sdfDateFormat2.parse(deliveryTime2);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			String nums2=request.getParameter("nums2");
			String numsprice2=request.getParameter("numsprice2");
			String adduser2=request.getParameter("addusers2");
			String remarks2=request.getParameter("remarks2");
			saleOrder saleorder2=new saleOrder();
			saleorder2.setCode(code2);
			saleorder2.setOrderDate(orderDate2);
			saleorder2.setCustomercode(customercode2);
			saleorder2.setAddUser(adduser2);
			saleorder2.setState(state2);
			saleorder2.setContacter(contacter2);
			saleorder2.setTelphone(telphone2);
			saleorder2.setFax(fax2);
			saleorder2.setTrans(trans2);
			saleorder2.setBusinesser(businesser2);
			saleorder2.setDeliveryDate(deliverydate2);
			saleorder2.setNums(Integer.parseInt(nums2));
			saleorder2.setNumsPrice(Double.parseDouble(numsprice2));
			int res=order.update(saleorder2);
		}
		response.sendRedirect("../erpSystem/orderManagement.jsp"); 
	}

}
