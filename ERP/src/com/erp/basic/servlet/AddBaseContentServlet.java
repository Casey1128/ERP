package com.erp.basic.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.basic.entity.BaseContent;
import com.erp.basic.service.BaseContentService;
import com.erp.basic.service.impl.BaseContentServiceImpl;

public class AddBaseContentServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddBaseContentServlet() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		BaseContentService baseContentService=new BaseContentServiceImpl();
		BaseContent baseContent=new BaseContent();
		String category=request.getParameter("category");
		String code=request.getParameter("code");
		String codename=request.getParameter("codename");
		String orderno=request.getParameter("orderno");
		String status=request.getParameter("status");
		String remarks=request.getParameter("remarks");
		baseContent.setCategoryCode(category);
		baseContent.setCode(code);
		baseContent.setCodeName(codename);
		baseContent.setOrderNo(orderno);
		baseContent.setIsShow(Integer.parseInt(status));
		baseContent.setRemarks(remarks);
		baseContent.setCompCode("GS20150527094503");
		int ret=0;
		ret=baseContentService.add(baseContent);
		if(ret==1){
			System.out.println("添加成功！");
			response.sendRedirect("SearchBaseContentServlet");
		}else{
			System.out.println("添加失败!");
		}
	}

}
