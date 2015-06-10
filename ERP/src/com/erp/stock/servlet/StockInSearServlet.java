package com.erp.stock.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.erp.stock.service.StockInService;
import com.erp.stock.service.Impl.StockInServiceImpl;
import com.erp.utils.JSONDateProcessor;
import com.erp.utils.PageBean;

public class StockInSearServlet extends HttpServlet {

	public StockInSearServlet() {
		super();
	}

	StockInService stock=new StockInServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		
		String code=request.getParameter("searchcode");
		String startdatestr=request.getParameter("searchstartdate");
		String enddatestr =request.getParameter("searchenddate");
		

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date startdatetime=new Date();
		try {
			startdatetime=sdf.parse(startdatestr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date startdate=new java.sql.Date(startdatetime.getTime());
		
		java.util.Date enddatetime=new Date();
		try {
			enddatetime=sdf.parse(startdatestr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date enddate=new java.sql.Date(enddatetime.getTime());
		

		String pageNostr=request.getParameter("page");
		String pageSizestr=request.getParameter("rows");
		if(pageNostr==null||pageNostr.equals("")){pageNostr="1";}
		if(pageSizestr==null||pageSizestr.equals("")){pageSizestr="3";}
		int pageNo=Integer.parseInt(pageNostr);
		int pageSize=Integer.parseInt(pageSizestr);
		
		String sql1="select * from stockin where 1=1 ";
		String sql6="select count(*) from stockin where 1=1 ";
		String sql2="";
		String sql3="";
		String sql4="";
		List liststr=new ArrayList();
		if(code==null || code.equals("")){
			sql2="";
		}else{
			sql2="and code like '%'?'%' ";
		}
		if(startdate==null || startdate.equals("")){
			sql3="";
		}else{
			sql3="and indate>?";
		}
		if(enddate==null || enddate.equals("")){
			sql4="";
		}else{
			sql4="and indate<?";
		}
		String sql=sql1+sql2+sql3+sql4;
		String sqlcount=sql6+sql2+sql3+sql4;
		
		
		PageBean pb=new PageBean();
		pb=stock.SearchDataStIn(sql, sqlcount, pageNo, pageSize);
		
		
		JsonConfig config=new JsonConfig();
		config.registerJsonValueProcessor(Date.class,new JSONDateProcessor("yyyy-MM-dd"));
		
		Map attrs =new HashMap();
		JSONObject obj=new JSONObject();
		attrs.put("rows", pb.getData());
		attrs.put("total", pb.getRecordCount());
		
		obj.putAll(attrs,config);
		
		String data=obj.toString();	

		response.getWriter().println(data);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}