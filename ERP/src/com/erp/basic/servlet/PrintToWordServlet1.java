package com.erp.basic.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.utils.DocumentHandler;

public class PrintToWordServlet1 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PrintToWordServlet1() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String code=request.getParameter("printcode");
		String codename=request.getParameter("printcodename");
		String category=request.getParameter("printcategory");
		String orderno=request.getParameter("printorderno");
		String status=null;
		if(request.getParameter("printstatus").equals("1")){
			status="��ʾ";
		}else{
			status="����";
		}
		String remarks=request.getParameter("printremarks");
       Map<String, Object> dataMap = new HashMap<String, Object>();  
		 
		 dataMap.put("code", code);
		 dataMap.put("codename", codename);
		 dataMap.put("category", category);
		 dataMap.put("orderno", orderno);
		 dataMap.put("status", status);
		 dataMap.put("remarks", remarks);
		 //����word
		 DocumentHandler doc = new DocumentHandler();    
		 doc.createDoc(dataMap, "E:/�ֵ�������Ϣ��ӡ.doc"); 
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
