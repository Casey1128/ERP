package com.erp.basic.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.utils.DocumentHandler4;
import com.erp.utils.UnitCode;

public class PrintTowordServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PrintTowordServlet() {
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

		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
			String code=request.getParameter("code1");
	       String pname=request.getParameter("pname1");
	       String date=request.getParameter("date1");
	       String contacter=request.getParameter("contacter1");
	       String telephone=request.getParameter("telephone1");
	       String fax=request.getParameter("fax1");
	       String postcide=request.getParameter("postcide1");
	       String email=request.getParameter("email1");
	       String province=request.getParameter("province1");
	       String city=request.getParameter("city1");
	       String address=request.getParameter("address1");
	       String legaler=request.getParameter("legaler1");
	       String url=request.getParameter("url1");
	       String qq=request.getParameter("qq1");
	       String aliwang=request.getParameter("aliwang1");
	       String msn=request.getParameter("msn1");
	       String agent=request.getParameter("agent1");
	       String bank=request.getParameter("bank1");
	       String account=request.getParameter("account1");
	       String tax=request.getParameter("tax1"); 
	       String categorycode=request.getParameter("categorycode1");	    
	       String ids=request.getParameter("ids1");		
	       String isShow=null;
	       String ret=request.getParameter("isShow1");
	       if(ret==null||ret==""){
	    	   ret="2";
	       }
	       if(ret.equals("1")){
				isShow="ÏÔÊ¾";
			}else{
				isShow="Òþ²Ø";
			}
		String remarks=request.getParameter("remarks1");
		
       Map<String, Object> dataMap = new HashMap<String, Object>();  
		 
		 dataMap.put("code", code);
		 dataMap.put("csName", pname);
		 dataMap.put("addDate", date);
		 dataMap.put("categorycode", categorycode);
		 dataMap.put("contacter", contacter);
		 
		 dataMap.put("telephone", telephone);
		 dataMap.put("isShow", isShow);
		 dataMap.put("remarks", remarks);
		 dataMap.put("fax", fax);
		 dataMap.put("postCode", postcide);
		 
		 dataMap.put("email", email);
		 dataMap.put("province", province);
		 dataMap.put("city", city);
		 dataMap.put("address", address);
		 dataMap.put("legaler", legaler);
		 
		 dataMap.put("url", url);
		 dataMap.put("QQ", qq);
		 dataMap.put("aliwang", aliwang);
		 dataMap.put("MSN", msn);
		 dataMap.put("agent", agent);
		 
		 dataMap.put("bank", bank);
		 dataMap.put("account", account);
		 dataMap.put("tax", tax);	 
		 //µ¼³öword
		 DocumentHandler4 doc = new DocumentHandler4();   
		 UnitCode unitCode=new UnitCode();
		 String id=unitCode.getUnitCode();
		 doc.createDoc(dataMap, "E://dc//"+id+".doc");
		 response.sendRedirect("/ERP/Unit/unitIndex.jsp");
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
