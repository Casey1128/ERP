package com.erp.basic.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.utils.DocumentHandler1;

public class getWordServlet extends HttpServlet {

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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String partsCode=request.getParameter("partsCode");
		String partsName=request.getParameter("partsName");
		String partsCategory=request.getParameter("partsCategory");
		String partsBrand=request.getParameter("partsBrand");
		String partsGeneralpartsno=request.getParameter("partsGeneralpartsno");
		String partsModelOld=request.getParameter("partsModelOld");
		String partsModel=request.getParameter("partsModel");
		String partsSize=request.getParameter("partsSize");
		String partsWeight=request.getParameter("partsWeight");
		String partsImg=request.getParameter("partsImg");
		String partsUnit=request.getParameter("partsUnit");
		String salePrice=request.getParameter("salePrice");
		String isShow=request.getParameter("isShow");
		String remarks=request.getParameter("remarks");
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("partsCode", partsCode);
		dataMap.put("partsName", partsName);
		dataMap.put("partsCategory",partsCategory);
		dataMap.put("partsBrand",partsBrand);
		dataMap.put("partsGeneralpartsno",partsGeneralpartsno);
		dataMap.put("partsModelOld", partsModelOld);
		dataMap.put("partsModel",partsModel);
		dataMap.put("partsModelOld",partsModelOld);
		dataMap.put("partsSize",partsSize);
		dataMap.put("partsWeight",partsWeight);
		dataMap.put("partsImg",partsImg);
		dataMap.put("partsUnit",partsUnit);
		dataMap.put("salePrice",salePrice);
		dataMap.put("isShow",isShow);
		dataMap.put("remarks",remarks);
		 
		 //导出word
		DocumentHandler1 doc = new DocumentHandler1();    
		doc.createDoc(dataMap, "E://配件信息管理.doc"); 
		
	}

}
