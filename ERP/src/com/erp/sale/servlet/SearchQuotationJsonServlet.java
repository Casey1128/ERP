package com.erp.sale.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.erp.sale.entity.saleQuotation;
import com.erp.sale.service.SaleService;
import com.erp.sale.service.saleQuotationService;
import com.erp.sale.service.impl.SaleServiceImpl;
import com.erp.sale.service.impl.saleQuotationServiceimpl;
import com.erp.utils.DateUtil;
import com.erp.utils.PageBean;

public class SearchQuotationJsonServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SearchQuotationJsonServlet() {
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
	public saleQuotationService saleQuoService=new saleQuotationServiceimpl(); 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
       // request.setCharacterEncoding("utf-8");
       // response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		String code=request.getParameter("code");
		String csname=request.getParameter("csName");
		String startdate=request.getParameter("startdate");
		String enddate=request.getParameter("enddate");
		String pageNo=request.getParameter("page");
		String pageSize=request.getParameter("rows");
		if(pageNo==null||pageNo.equals("")){
			pageNo="1";
		}
		if(pageSize==null||pageSize.equals("")){
			pageSize="5";
		}
		basecusTomerSipplier bSipplier=new basecusTomerSipplier();
		saleQuotation sQuotation=new saleQuotation();
		if(code!=null&&!code.equals("")){
			sQuotation.setCode(code);
		}
		if(csname!=null&&!csname.equals("")){
			bSipplier.setCsName(csname);
			sQuotation.setbSipplier(bSipplier);
		}
		if(startdate!=null&&!startdate.equals("")){
		DateUtil dateUtil=new DateUtil();
			try {
				sQuotation.setStartdate(dateUtil.toDate(startdate));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(enddate!=null&&!enddate.equals("")){
			DateUtil dateUtil=new DateUtil();
				try {
					sQuotation.setEnddate(dateUtil.toDate(enddate));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		
		PageBean pb=saleQuoService.searchSaleQuotation(Integer.parseInt(pageNo),
				Integer.parseInt(pageSize),sQuotation);
		pb.setPageNo(Integer.parseInt(pageNo));
		pb.setPageSize(Integer.parseInt(pageSize));
		JsonConfig  config=new JsonConfig();
		JSONObject jsonObject=new JSONObject();
		Map attrs=new HashMap();
		attrs.put("rows", pb.getData());
		attrs.put("total", pb.getRecordCount());
		jsonObject.putAll(attrs,config);
	//	jsonObject.put("rows",pb.getData());
		
		String data=jsonObject.toString();
		//System.out.println(data);
		//System.out.println(pageNo+"-----"+pageSize);
		System.out.println("************************");
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
