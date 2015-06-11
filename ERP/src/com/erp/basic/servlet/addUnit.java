package com.erp.basic.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.basic.entity.basecusTomerSipplier;
import com.erp.basic.service.UnitService;
import com.erp.basic.service.impl.UnitServiceImpl;
import com.erp.utils.DateUtil;

public class addUnit extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public addUnit() {
		super();
	}

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
	private UnitService unitService=new UnitServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String code=request.getParameter("code");
       String pname=request.getParameter("pname");
       String date=request.getParameter("date");
       String contacter=request.getParameter("contacter");
       String telephone=request.getParameter("telephone");
       String fax=request.getParameter("fax");
       String postcide=request.getParameter("postcide");
       String email=request.getParameter("email");
       String prov=request.getParameter("province");
       String city=request.getParameter("city");
       String address=request.getParameter("address");
       String legaler=request.getParameter("legaler");
       String url=request.getParameter("url");
       String qq=request.getParameter("qq");
       String aliwang=request.getParameter("aliwang");
       String msn=request.getParameter("msn");
       String agent=request.getParameter("agent");
       String bank=request.getParameter("bank");
       String account=request.getParameter("account");
       String tax=request.getParameter("tax");
       String isshow=request.getParameter("isshow");
       String categorycode=request.getParameter("categorycode");
       String remarks=request.getParameter("remarks");
       String ids=request.getParameter("ids");
       
       DateUtil dateUtil=new DateUtil();
       java.util.Date addDate=null;
       try {
		addDate=dateUtil.toDate(date);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
       basecusTomerSipplier bSipplier=new basecusTomerSipplier();
       bSipplier.setCode(code);
       bSipplier.setCsName(pname);
//       try {
//		cs.setAddDate(DateUtil.toDate(date));
//	} catch (ParseException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
       bSipplier.setContacter(contacter);
       bSipplier.setTelephone(telephone);
       bSipplier.setFax(fax);
       bSipplier.setAddDate(addDate);
       bSipplier.setPostcide(postcide);
       bSipplier.setEmall(email);
       bSipplier.setProvince(prov);
       bSipplier.setCity(city);
       bSipplier.setAddress(address);
       bSipplier.setLegaler(legaler);
       bSipplier.setUrl(url);
       bSipplier.setQq(qq);
       bSipplier.setAliwang(aliwang);
       bSipplier.setMsn(msn);
       bSipplier.setAgent(agent);
       bSipplier.setBank(bank);
       bSipplier.setAccount(account);
       bSipplier.setTax(tax);
       bSipplier.setIsShow(isshow);
       bSipplier.setCategorycode(categorycode);
       bSipplier.setReMarks(remarks);
       
       int ret=0;
       if(ids.equals("1")){
    	   unitService.addUnit(bSipplier);
       }
       if(ids.equals("2")){
    	   
    	 ret=unitService.updateUnit(bSipplier);
       }
     //  System.out.println(ret);
      // System.out.println(date);
     //  System.out.println(code+ " "+pname);
       
	  response.sendRedirect("/ERP/Unit/unitIndex.jsp");
       
	}

	
}
