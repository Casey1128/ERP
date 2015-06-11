package com.erp.stock.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.erp.stock.service.StockInService;
import com.erp.stock.service.Impl.StockInServiceImpl;
import com.erp.utils.PageBean;

public class StockInServlet extends HttpServlet {

	public StockInServlet() {
		super();
	}

	StockInService stockin=new StockInServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		PageBean pb=new PageBean();
		String pgNo=request.getParameter("page");
		String pgSize=request.getParameter("rows");
		if(pgNo.equals("")||pgNo==null)pgNo="1";
		if(pgSize.equals("")||pgSize==null)pgSize="3";
		int pageNo=Integer.parseInt(pgNo);
		int pageSize=Integer.parseInt(pgSize);
		pb=stockin.findAllDataStIn(pageNo, pageSize);
		JSONObject obj=new JSONObject();
		obj.put("rows",pb.getData());
		obj.put("total", pb.getRecordCount());
		String data=obj.toString();
		response.getWriter().println(data);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}