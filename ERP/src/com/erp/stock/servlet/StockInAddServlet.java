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

import com.erp.stock.entity.StockIn;
import com.erp.stock.entity.StockInDetail;
import com.erp.stock.entity.others.BaseCustomerSupplier;
import com.erp.stock.service.StockInService;
import com.erp.stock.service.Impl.StockInServiceImpl;
import com.erp.utils.DateUtil;
import com.erp.utils.JSONDateProcessor;
import com.erp.utils.PageBean;

public class StockInAddServlet extends HttpServlet {

	public StockInAddServlet() {
		super();
	}

	StockInService stock=new StockInServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		DateUtil dus=new DateUtil();
		String opt=request.getParameter("opt");
		System.out.println(opt);
		
		
		
		if(opt.equals("1")){
			String pageNostr=request.getParameter("page");
			String pageSizestr=request.getParameter("rows");
			if(pageNostr==null||pageNostr.equals("")){pageNostr="1";}
			if(pageSizestr==null||pageSizestr.equals("")){pageSizestr="3";}
			int pageNo=Integer.parseInt(pageNostr);
			int pageSize=Integer.parseInt(pageSizestr);
			
			PageBean pb=new PageBean();
			pb=stock.findSupplier(pageNo, pageSize);
			
			JSONObject jsonObj=new JSONObject();
			jsonObj.put("rows",pb.getData());
			jsonObj.put("total",pb.getRecordCount());
			String data=jsonObj.toString();	
			System.out.println(data);
			response.getWriter().println(data);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}