package com.erp.stock.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.erp.utils.PageBean;

public class StockInSearServlet extends HttpServlet {

	public StockInSearServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		String code=request.getParameter("searchcode");
		String startdate=request.getParameter("searchstartdate");
		String enddate =request.getParameter("searchenddate");
		String pageNostr=request.getParameter("page");
		String pageSizestr=request.getParameter("rows");
		if(pageNostr==null||pageNostr.equals("")){pageNostr="1";}
		if(pageSizestr==null||pageSizestr.equals("")){pageSizestr="3";}
		int pageNo=Integer.parseInt(pageNostr);
		int pageSize=Integer.parseInt(pageSizestr);
		
		String sql1="select  from where 1=1";
		String sql6="select  from where 1=1";
		String sql2="";
		String sql3="";
		String sql4="";
		String sql5="";
		List liststr=new ArrayList();
		if(code==null || code.equals("")){
			sql2="";
		}else{
			sql2="";
		}
		if(startdate==null || startdate.equals("")){
			sql3="";
		}else{
			sql3="";
		}
		if(enddate==null || enddate.equals("")){
			sql4="";
		}else{
			sql4="";
		}
		String sql=sql1+sql2+sql3+sql4+sql5;
		String sqlcount=sql6+sql2+sql3+sql4+sql5;
		
		PageBean pb=new PageBean();
		
		
		
		
		
		
		
		pb.setPageNo(pageNo);
		pb.setPageSize(pageSize);
		
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("rows", pb.getData());
		jsonobj.put("total", pb.getRecordCount());
		
		jsonobj.putAll(jsonobj);
		
		String data=jsonobj.toString();	

		response.getWriter().println(data);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}