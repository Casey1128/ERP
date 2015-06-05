package com.erp.purchase.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.purchase.entity.PurchaseReturn;
import com.erp.purchase.service.PurchaseReturnService;
import com.erp.purchase.service.impl.PurchaseReturnServiceImpl;
import com.erp.utils.PageBean;

public class SearchReturnByConditionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SearchReturnByConditionServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	private PurchaseReturnService purchaseReturnService = new PurchaseReturnServiceImpl();

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
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		String code = request.getParameter("searchcode");
		String startDate = request.getParameter("searchstartdate");
		String endDate = request.getParameter("searchenddate");
		Date d1,d2=new Date();
		
		try {
			if(startDate.equals("")){
				d1=null;
			}else{
				d1=sdf.parse(startDate);
			}
			if(endDate.equals("")){
				d2=null;
			}else{
				d2=sdf.parse(endDate);
			}
			String supplier = request.getParameter("searchsupplier");
			PageBean pageBean = purchaseReturnService.SearchByCondition(code,
					d1, d2, supplier, Integer.parseInt(pageNo),
					Integer.parseInt(pageSize));
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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
