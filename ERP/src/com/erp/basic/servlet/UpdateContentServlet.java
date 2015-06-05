package com.erp.basic.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.basic.entity.BaseContent;
import com.erp.basic.service.BaseContentService;
import com.erp.basic.service.impl.BaseContentServiceImpl;

public class UpdateContentServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateContentServlet() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		BaseContent baseContent=new BaseContent();
		String code=request.getParameter("code");
		String category=request.getParameter("category");
		String codename=request.getParameter("codename");
		System.out.println(code+"----"+category);
		
		BaseContentService baseContentService=new BaseContentServiceImpl();
		baseContent=baseContentService.findByCaCode(category, code);
		baseContent.setCodeName(codename);
		System.out.println(baseContent.getCodeName());
		int ret=0;
		
		ret=baseContentService.modify(baseContent);
		if(ret>0){
			System.out.println("更新成功！");
			response.sendRedirect("SearchBaseContentServlet");
		}else{
			System.out.println("更新失败！");
		}

	
	}

}
