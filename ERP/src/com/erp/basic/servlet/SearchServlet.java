package com.erp.basic.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.erp.basic.entity.basecusTomerSipplier;
import com.erp.basic.service.UnitService;
import com.erp.basic.service.impl.UnitServiceImpl;
import com.erp.utils.DateUtil;
import com.erp.utils.PageBean;


public class SearchServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SearchServlet() {
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
	public UnitService unitServlet=new UnitServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/json;charset=utf-8");
		String code=request.getParameter("code");
		String csname=request.getParameter("csName");
		String optdate=request.getParameter("addDate");
		String pageNo=request.getParameter("page");
		String pageSize=request.getParameter("rows");
		if(pageNo==null||pageNo.equals("")){
			pageNo="1";
		}
		if(pageSize==null||pageSize.equals("")){
			pageSize="5";
		}
		basecusTomerSipplier bSipplier=new basecusTomerSipplier();
		
		if(code!=null&&!code.equals("")){
			bSipplier.setCode(code);
		}
		if(csname!=null&&!csname.equals("")){
			bSipplier.setCsName(csname);
		}
		if(optdate!=null&&!optdate.equals("")){
			DateUtil dateUtil=new DateUtil();
			try {
				bSipplier.setAddDate(dateUtil.toDate(optdate));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		PageBean pb=unitServlet.findList(bSipplier,Integer.parseInt(pageNo),
				Integer.parseInt(pageSize));
		pb.setPageNo(Integer.parseInt(pageNo));
		pb.setPageSize(Integer.parseInt(pageSize));
		JsonConfig  config=new JsonConfig();
		JSONObject jsonObject=new JSONObject();
		Map attrs=new HashMap();
		attrs.put("rows", pb.getData());
		attrs.put("total", pb.getRecordCount());
		jsonObject.putAll(attrs,config);		
		String data=jsonObject.toString();
		System.out.println(data);
        response.getWriter().println(data);
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
