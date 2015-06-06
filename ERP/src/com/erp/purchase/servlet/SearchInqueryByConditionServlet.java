package com.erp.purchase.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.purchase.entity.PurchaseInquery;
import com.erp.purchase.service.PurchaseInqueryService;
import com.erp.purchase.service.impl.PurchaseInqueryServiceImpl;
import com.erp.utils.PageBean;

public class SearchInqueryByConditionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SearchInqueryByConditionServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	private PurchaseInqueryService purchaseInqueryService=new PurchaseInqueryServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");
		if (pageNo == null || pageNo.equals("")) {
			pageNo = "1";
		}
		if (pageSize == null || pageSize.equals("")) {
			pageSize = "3";
		}
		SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
		String code = request.getParameter("searchcode");
		String startDate = request.getParameter("searchstartdate");
		String endDate = request.getParameter("searchenddate");
		java.util.Date d1=new java.util.Date();
		java.util.Date d2=new java.util.Date();
		try {
			if(startDate==null||startDate.equals("")){
				d1=null;
			}else{
				d1=sdf1.parse(startDate);
			}
			if(endDate==null||endDate.equals("")){
				d2=null;
			}else{
				d2=sdf1.parse(endDate);
			}
			String supplier = request.getParameter("searchsupplier");
			PageBean pageBean = purchaseInqueryService.SearchByCondition(code,
					d1, d2, supplier, Integer.parseInt(pageNo),
					Integer.parseInt(pageSize));
			pageBean.setPageNo(Integer.parseInt(pageNo));
			pageBean.setPageSize(Integer.parseInt(pageSize));
			List<PurchaseInquery> list = new ArrayList<PurchaseInquery>();
			list = purchaseInqueryService.findAll();
			if (pageBean != null && list != null) {
				request.setAttribute("pageBean", pageBean);
				request.setAttribute("plist", list);
				request.getSession().setAttribute("Bean", pageBean);
			}
			request.getRequestDispatcher("/erpSystem/purchaseInqueryManagement.jsp")
					.forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
