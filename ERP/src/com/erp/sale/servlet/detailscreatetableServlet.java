package com.erp.sale.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.New;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.erp.sale.service.SaleReturn_DetailService;
import com.erp.sale.service.impl.SaleReturn_DetailServiceImpl;
import com.erp.utils.JSONDateProcessor;
import com.erp.utils.PageBean;

public class detailscreatetableServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	private SaleReturn_DetailService srds=new SaleReturn_DetailServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/json; charset=utf-8");
		String pageNo=request.getParameter("page");
		String pageSize=request.getParameter("rows");
		
		String partsNo=request.getParameter("partsNo");
		String partsName=request.getParameter("partsName");
		
		String ckCode=request.getParameter("code");
		
		SimpleDateFormat sdFormat=new SimpleDateFormat("yyyy-MM-dd");
			
		/*if(startDate==null||startDate.equals("")){
			startTime=null;
		}else{
			try {
				startTime=sdFormat.parse(startDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(endDate==null||endDate.equals("")){
			endTime=null;
		}else{
			try {
				endTime=sdFormat.parse(endDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		PageBean pageBean=srds.getStockOutList(partsNo, partsName, ckCode, 
				Integer.parseInt(pageNo), Integer.parseInt(pageSize));
		JsonConfig config=new JsonConfig();
		request.getSession().setAttribute("Bean", pageBean);
		//config.setExcludes(new String[]{"fax","remarks","isShow","compCode","addDate","addUser","addIp"});
		config.registerJsonValueProcessor(Date.class,new JSONDateProcessor());
		JSONObject jsonObject=new JSONObject();
		Map attrs=new HashMap();
		attrs.put("rows", pageBean.getData());
		attrs.put("total",pageBean.getRecordCount());
		jsonObject.putAll(attrs,config);
		String data=jsonObject.toString();
		System.out.println(data);
		response.getWriter().println(data);
	}

}
