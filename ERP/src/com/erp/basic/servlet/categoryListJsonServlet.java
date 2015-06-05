package com.erp.basic.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.erp.basic.service.BasePartsCategoryService;
import com.erp.basic.service.impl.BasePartsCategoryServiceImpl;
import com.erp.utils.JSONDateProcessor;
import com.erp.utils.PageBean;

public class categoryListJsonServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public categoryListJsonServlet() {
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
	private BasePartsCategoryService partsCategory=new BasePartsCategoryServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		String rows=request.getParameter("rows");
		String page=request.getParameter("page");
		
		String code=request.getParameter("code");
		String pcode=request.getParameter("pcode");
		PageBean partsPageBean=partsCategory.searchByCategory(code,pcode,Integer.parseInt(page),Integer.parseInt(rows));
		request.getSession().setAttribute("Bean",partsPageBean);
		JsonConfig config=new JsonConfig();
		config.setExcludes(new String[]{"compCode","addUserName","addIp"});//设置把哪些实体属性排除
		config.registerJsonValueProcessor(Date.class,new JSONDateProcessor("yyyy年MM月dd日"));
		JSONObject jsonObject=new JSONObject();
		Map attrs=new HashMap();
		attrs.put("rows",partsPageBean.getData());
		attrs.put("total", partsPageBean.getRecordCount());
		jsonObject.putAll(attrs,config);
		String data=jsonObject.toString();
		//System.out.println("dfgh"+data);
		response.getWriter().println(data);
	}

}
