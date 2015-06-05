package com.erp.basic.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.basic.entity.Baseparts;
import com.erp.basic.service.BasepartsService;
import com.erp.basic.service.impl.BasepartsServiceImpl;

public class BasepartsServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	private BasepartsService bs=new BasepartsServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String opt=request.getParameter("opt");
		
		String partsCode=request.getParameter("partsCode");
		String partsGeneralpartsno=request.getParameter("partsGeneralpartsno");
		String partsCategory=request.getParameter("partsCategory");
		String partsName=request.getParameter("partsName");
		String partsBrand=request.getParameter("partsBrand");
		String partsModel=request.getParameter("partsModel");
		String partsModelOld=request.getParameter("partsModelOld");
		String salePrice=request.getParameter("salePrice");
		String isShow=request.getParameter("isShow");
		String addUserName=request.getParameter("addUserName");
		String remarks=request.getParameter("remarks");
		if(opt!=null&&opt.equals("1")){
			//1Ìí¼Ó
			Baseparts bp=new Baseparts();
			bp.setPartsCode(partsCode);
			bp.setPartsGeneralpartsno(partsGeneralpartsno);
			bp.setPartsCategory(partsCategory);
			bp.setPartsName(partsName);
			bp.setPartsBrand(partsBrand);
			bp.setPartsModel(partsModelOld);
			bp.setPartsModelOld(partsModelOld);
			bp.setSalePrice(Integer.parseInt(salePrice));
			bp.setIsShow(isShow);
			bp.setAddUserName(addUserName);
			bp.setRemarks(remarks);
			int date=bs.add(bp);
			System.out.println(date);
			
		}else{
			Baseparts bp=new Baseparts();
			bp.setPartsCode(partsCode);
			bp.setPartsGeneralpartsno(partsGeneralpartsno);
			bp.setPartsCategory(partsCategory);
			bp.setPartsName(partsName);
			bp.setPartsBrand(partsBrand);
			bp.setPartsModel(partsModelOld);
			bp.setPartsModelOld(partsModelOld);
			bp.setSalePrice(Integer.parseInt(salePrice));
			bp.setIsShow(isShow);
			bp.setAddUserName(addUserName);
			bp.setRemarks(remarks);
			bs.updateBaseparts(bp);
		}
		response.sendRedirect("/ERP/console/baseparts/basepartsList.jsp");
		
	}

}
