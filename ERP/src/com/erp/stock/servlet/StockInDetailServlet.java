package com.erp.stock.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.erp.stock.entity.StockInDetail;
import com.erp.stock.service.StockInService;
import com.erp.stock.service.Impl.StockInServiceImpl;

public class StockInDetailServlet extends HttpServlet {

	public StockInDetailServlet() {
		super();
	}

	StockInService stockin=new StockInServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		String incode=request.getParameter("incode");
		List<StockInDetail> list=new ArrayList<StockInDetail>();
		list=stockin.findAllDataStInDetail(incode);
		
		JSONArray arr=JSONArray.fromObject(list);
		String data=arr.toString();
		System.out.println(data);
		response.getWriter().println(data);
		
//		JSONObject obj=new JSONObject();
//		obj.put("rows", list);
//		String data=obj.toString();
//		System.out.println(data);
//		response.getWriter().println(data);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}