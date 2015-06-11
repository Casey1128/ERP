package com.erp.basic.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.erp.basic.service.BasepartsService;
import com.erp.basic.service.impl.BasepartsServiceImpl;
import com.erp.utils.PageBean;


public class SearchBasepartsjsonServlet extends HttpServlet {

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
	private BasepartsService bService=new BasepartsServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/json;charset=utf-8");
		String pageNo=request.getParameter("page");
		String pageSize=request.getParameter("rows");
		String partsGeneralpartsno=request.getParameter("partsGeneralpartsno");
		String partsName=request.getParameter("partsName");
		String partsCategory=request.getParameter("partsCategory");
		if(pageNo==null||pageNo==""){
			pageNo="1";
		}
		if(pageSize==null||pageSize==""){
			pageSize="3";
		}
		PageBean pb=bService.getBasepartsAll(partsGeneralpartsno,partsName,partsCategory,Integer.parseInt(pageNo),Integer.parseInt(pageSize) );
		request.getSession().setAttribute("Bean", pb);
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("rows", pb.getData());
		jsonObject.put("total",pb.getRecordCount());
		String data=jsonObject.toString();
		System.out.println(data);
		response.getWriter().println(data);
	}

}
