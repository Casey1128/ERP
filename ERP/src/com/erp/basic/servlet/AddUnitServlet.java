package com.erp.basic.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.basic.entity.basecusTomerSipplier;
import com.erp.utils.UnitCode;


public class AddUnitServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddUnitServlet() {
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
	//private UnitService unitService=new UnitServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			UnitCode uc=new UnitCode();
		    String code= uc.getUnitCode();
		    Date date=new Date();
		    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String time=sdf.format(date);
			
			basecusTomerSipplier bSipplier=new basecusTomerSipplier();
			bSipplier.setCode(code);
			
			List<basecusTomerSipplier> list=new ArrayList<basecusTomerSipplier>();
			list.add(bSipplier);
			request.setAttribute("list",list);
			
			request.getRequestDispatcher("/Unit/addUnit.jsp").forward(request, response);
	}

}
