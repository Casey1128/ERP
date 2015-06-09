package com.erp.sale.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.erp.sale.service.orderService;
import com.erp.sale.service.impl.orderServiceImpl;
import com.erp.utils.JSONDateProcessor;
import com.erp.utils.PageBean;

public class orderListJsonServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public orderListJsonServlet() {
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
			this.doPost(request,response);
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
		String rows=request.getParameter("rows");
		String page=request.getParameter("page");
		
		String code=request.getParameter("code");
		String startDate=request.getParameter("startDate");
		String endDate=request.getParameter("endDate");
		String customerCode=request.getParameter("customercode");
		SimpleDateFormat sdFormat=new SimpleDateFormat("MM/dd/yyyy");
		Date startTime=new Date();
		Date endTime=new Date();
		if(startDate==null||startDate.equals("")){
			startTime=null;
		}else{
			try {
				startTime=sdFormat.parse(startDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(endDate==null||endDate.equals("")){
			endTime=null;
		}else{
			try {
				endTime=sdFormat.parse(endDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
PageBean orderPageBean=order.searchOrder(code, startTime, endTime,customerCode,Integer.parseInt(page),Integer.parseInt(rows));
		request.getSession().setAttribute("orderBean", orderPageBean);
		JsonConfig config=new JsonConfig();
		config.setExcludes(new String[]{"fax","trans","deliveryDate"
				,"remarks","isShow","adddDate","addUserName","addIp"});
		config.registerJsonValueProcessor(Date.class,new JSONDateProcessor("yyyyƒÍMM‘¬dd»’"));
		JSONObject jsonObject=new JSONObject();
		Map attrs=new HashMap();
		attrs.put("rows", orderPageBean.getData());
		attrs.put("total",orderPageBean.getRecordCount());
		jsonObject.putAll(attrs,config);
		String datas=jsonObject.toString();
		//System.out.println("dfgh:"+datas);
		response.getWriter().println(datas);

	}

}
