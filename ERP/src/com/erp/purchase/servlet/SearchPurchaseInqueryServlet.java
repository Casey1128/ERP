package com.erp.purchase.servlet;

import java.io.IOException;
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

public class SearchPurchaseInqueryServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SearchPurchaseInqueryServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

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
		PurchaseInqueryService purchaseInqueryService = new PurchaseInqueryServiceImpl();
		PageBean pageBean = purchaseInqueryService.SearchAll(
				Integer.parseInt(pageNo), Integer.parseInt(pageSize));

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
	}

}
