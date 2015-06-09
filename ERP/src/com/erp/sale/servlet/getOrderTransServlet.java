package com.erp.sale.servlet;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.erp.sale.entity.saleOrder;
import com.erp.sale.service.orderService;
import com.erp.sale.service.impl.orderServiceImpl;

public class getOrderTransServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public getOrderTransServlet() {
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
		List<saleOrder> orderList=new ArrayList<saleOrder>();
		orderList=order.getTrans();
		
		JSONArray array=JSONArray.fromObject(orderList);
		String jsonOrderList=array.toString();
		response.getWriter().println(jsonOrderList);
	}

}
