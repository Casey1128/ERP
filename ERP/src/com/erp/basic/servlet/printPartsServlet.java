package com.erp.basic.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.utils.DocumentHandler3;

public class printPartsServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public printPartsServlet() {
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String pcode=request.getParameter("lpcode");
		String categoryName=request.getParameter("lcategoryname");
		String addUser=request.getParameter("laddUser");
		String status=null;
		if(request.getParameter("lisshow").equals("1")){
			status="显示";
		}else{
			status="隐藏";
		}
		String remarks=request.getParameter("lremarks");
       Map<String, Object> dataMap = new HashMap<String, Object>();  
		 
       	 dataMap.put("pcode", pcode);
		 dataMap.put("categoryName", categoryName);
		 dataMap.put("addUser", addUser);
		 dataMap.put("status", status);
		 dataMap.put("remarks", remarks);
		 //导出word
		 DocumentHandler3 doc = new DocumentHandler3();    
		 doc.createDoc(dataMap, "E:/配件类别信息打印界面.doc"); 
		 response.sendRedirect("../erpSystem/PageBean.jsp"); 
	}

}
