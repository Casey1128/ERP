package com.erp.purchase.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.purchase.entity.PurchaseInquery;
import com.erp.purchase.entity.PurchaseReturn;
import com.erp.purchase.service.PurchaseReturnService;
import com.erp.purchase.service.impl.PurchaseReturnServiceImpl;
import com.erp.utils.PageBean;

public class SearchPurchaseReturnServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SearchPurchaseReturnServlet() {
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
		PurchaseReturnService purchaseReturnService = new PurchaseReturnServiceImpl();
		PageBean pageBean = purchaseReturnService.SearchAll(
				Integer.parseInt(pageNo), Integer.parseInt(pageSize));

		pageBean.setPageNo(Integer.parseInt(pageNo));
		pageBean.setPageSize(Integer.parseInt(pageSize));
		List<PurchaseReturn> list = new ArrayList<PurchaseReturn>();
		list = purchaseReturnService.findAll();
		if (pageBean != null && list != null) {
			request.setAttribute("pageBean", pageBean);
			request.setAttribute("plist", list);
			request.getSession().setAttribute("Bean", pageBean);
		}
		request.getRequestDispatcher("/erpSystem/purchaseReturnManagement.jsp")
				.forward(request, response);
	}

}
