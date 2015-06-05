package com.erp.purchase.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.erp.purchase.entity.PurchaseReturn;
import com.erp.purchase.service.PurchaseReturnService;
import com.erp.purchase.service.impl.PurchaseReturnServiceImpl;
import com.erp.utils.JSONDateProcessor;

public class SearchReturnByServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SearchReturnByServlet() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String code=request.getParameter("code");
		PurchaseReturn purchaseReturn=new PurchaseReturn();
		PurchaseReturnService purchaseReturnService=new PurchaseReturnServiceImpl();
		purchaseReturn=purchaseReturnService.findByCode(code);
		purchaseReturn.setrDate(new Date(purchaseReturn.getrDate().getTime()));
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.registerJsonValueProcessor(Date.class, new JSONDateProcessor());
		JSONObject obj=new JSONObject();
		obj=JSONObject.fromObject(purchaseReturn,jsonConfig);
		String data=obj.toString();
		System.out.println(data);
		response.getWriter().println(data);
			
		
	
		

	}

}
