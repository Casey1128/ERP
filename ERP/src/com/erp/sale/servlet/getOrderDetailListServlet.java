package com.erp.sale.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.erp.sale.entity.saleOrderDetails;
import com.erp.sale.service.orderService;
import com.erp.sale.service.impl.orderServiceImpl;

public class getOrderDetailListServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public getOrderDetailListServlet() {
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
	private orderService orderDetails=new orderServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		String scode=request.getParameter("code");
		List<saleOrderDetails> detailsList=new ArrayList<saleOrderDetails>();
		detailsList=orderDetails.orderDetails(scode);
		JSONObject jsonObject=new JSONObject();
		Map attrs=new HashMap();
		attrs.put("rows", detailsList);
		jsonObject.putAll(attrs);
		String datas=jsonObject.toString();
		//System.out.println(datas);
		response.getWriter().println(datas);
	}

}
