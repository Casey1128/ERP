package com.erp.basic.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.basic.entity.BasePartsCategory;
import com.erp.basic.service.BasePartsCategoryService;
import com.erp.basic.service.impl.BasePartsCategoryServiceImpl;

public class categoryServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public categoryServlet() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		this.doPost(request,response);
	}
	private BasePartsCategoryService parts=new BasePartsCategoryServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String opt=request.getParameter("opt");
		String categoryname=request.getParameter("categoryname");
		String pcode=request.getParameter("pcode");
		String remarks=request.getParameter("remarks");
		String isshow=request.getParameterValues("isshow")[0];
		String code=request.getParameter("code");
		String addUser=request.getParameter("addUser");
		
		BasePartsCategory partsCategory=new BasePartsCategory();
		partsCategory.setCode(code);
		partsCategory.setCategoryName(categoryname);
		partsCategory.setPcode(pcode);
		partsCategory.setRemarks(remarks);
		partsCategory.setIsShow(isshow);
		partsCategory.setAddUser(addUser);
		if(opt.equals("1")){
			int ret1=parts.insert(partsCategory);
		}else{//ÐÞ¸Ä
			int ret2=parts.update(partsCategory);
		}
		
		response.sendRedirect("../erpSystem/PageBean.jsp"); 
		//System.out.println("dfgh"+ret2);
	}
}
