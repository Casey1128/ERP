package com.erp.basic.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.basic.entity.BaseCompany;
import com.erp.basic.service.BaseCompanyService;
import com.erp.basic.service.impl.BaseCompanyServiceImpl;
import com.erp.utils.SysTools;

public class SearchBaseCompanyServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SearchBaseCompanyServlet() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		BaseCompanyService baseCompanyService=new BaseCompanyServiceImpl();
	    List<BaseCompany> list=baseCompanyService.searchAll();
	    SysTools st=new SysTools();
	    int ret=0;
	    if(list!=null){
	    	ret=list.size();
	    }
	    if(ret==1){
	        BaseCompany baseCompany=list.get(0);
	        request.setAttribute("baseCompany", baseCompany);
	    }
	    else{
	    	BaseCompany baseCompany=list.get(0);
	    	baseCompany.setCode(st.CreateCode("GS"));
	    	request.setAttribute("baseCompany", baseCompany);
	    }
        request.getRequestDispatcher("/erpSystem/companyUpdate.jsp").forward(request, response);

	}

}
