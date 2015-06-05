package com.erp.basic.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.basic.entity.BaseCompany;
import com.erp.basic.service.BaseCompanyService;
import com.erp.basic.service.impl.BaseCompanyServiceImpl;

public class updateBaseCompanyServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public updateBaseCompanyServlet() {
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
		String code=request.getParameter("code");
		String compName=request.getParameter("compName");
		String compAddress=request.getParameter("compAddress");
		String compPostCode=request.getParameter("compPostCode");
		String compPhone=request.getParameter("compPhone");
		String compFax=request.getParameter("compFax");
		String compUrl=request.getParameter("compUrl");
		String compEmail=request.getParameter("compEmail");
		String compLegaler=request.getParameter("compLegaler");
		String compAgent=request.getParameter("compAgent");
		String compAccount=request.getParameter("compAccount");
		String compBank=request.getParameter("compBank");
		String compTax=request.getParameter("compTax");
		String remarks=request.getParameter("remarks");
		BaseCompany baseCompany=new BaseCompany();
		baseCompany.setCode(code);
		baseCompany.setCompName(compName);
		baseCompany.setCompAddress(compAddress);
		baseCompany.setCompPostCode(compPostCode);
		baseCompany.setCompPhone(compPhone);
		baseCompany.setCompFax(compFax);
		baseCompany.setCompUrl(compUrl);
		baseCompany.setCompEmail(compEmail);
		baseCompany.setCompLegaler(compLegaler);
		baseCompany.setCompAgent(compAgent);
		baseCompany.setCompAccount(compAccount);
		baseCompany.setCompBank(compBank);
		baseCompany.setCompTax(compTax);
		baseCompany.setRemarks(remarks);
		BaseCompanyService baseCompanyService=new BaseCompanyServiceImpl();
		int ret=0;
		ret=baseCompanyService.updateByCid(baseCompany);
		if(ret==1){
			System.out.println("更新成功!");
		}else{
			System.out.println("更新失败!");
		}
	}

}
