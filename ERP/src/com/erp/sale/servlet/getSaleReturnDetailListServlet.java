package com.erp.sale.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.erp.sale.entity.SaleReturnDETAIL3biao;

import com.erp.sale.service.SaleReturn_DetailService;
import com.erp.sale.service.impl.SaleReturn_DetailServiceImpl;

public class getSaleReturnDetailListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	private SaleReturn_DetailService srds=new SaleReturn_DetailServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		String code=request.getParameter("code");
		List<SaleReturnDETAIL3biao> detailsList=new ArrayList<SaleReturnDETAIL3biao>();
		detailsList=srds.getSaleReturn_Detail(code);
		JSONObject jsonObject=new JSONObject();
		Map attrs=new HashMap();
		attrs.put("rows", detailsList);
		jsonObject.putAll(attrs);
		String datas=jsonObject.toString();
		//System.out.println(datas);
		response.getWriter().println(datas);

	}

}
