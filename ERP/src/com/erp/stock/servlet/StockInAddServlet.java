package com.erp.stock.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.erp.stock.entity.StockIn;
import com.erp.stock.entity.StockInDetail;
import com.erp.stock.service.StockInService;
import com.erp.stock.service.Impl.StockInServiceImpl;
import com.erp.utils.DateUtil;
import com.erp.utils.JSONDateProcessor;

public class StockInAddServlet extends HttpServlet {

	public StockInAddServlet() {
		super();
	}

	StockInService stock=new StockInServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		DateUtil dus=new DateUtil();
		String opt=request.getParameter("opt");
		if(opt.equals("1")){
			String code=request.getParameter("code");
			
			
			String indatestr=request.getParameter("indate");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date indatetime=new Date();
			try {
				 indatetime=sdf.parse(indatestr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date indate=new java.sql.Date(indatetime.getTime());
			
			
			String supplierCode=request.getParameter("supplierCode");
			String contacter=request.getParameter("contacter");
			String telephone=request.getParameter("telephone");
			String fax=request.getParameter("fax");
			String intypese=request.getParameter("intypese");
			//String intypese = new String(request.getParameter("intypese").getBytes("ISO8859_1"),"utf-8");
			String intypere=request.getParameter("intypere");
			if(intypere.equals("0")){intypere="正常入库";}
			if(intypere.equals("1")){intypere="冲抵入库";}
			String intype=intypese+"-"+intypere;
			String isinvoice=request.getParameter("isinvoice");
			String remarks=request.getParameter("remarks");
			
			
			List<StockIn> liststr=new ArrayList<StockIn>();
			liststr=stock.findDataStInByCode(code);
			if( liststr.size()!=0){
				stock.delDataStIn(code);
			}
			
			
			Object[] obj=new Object[]{code,indate,supplierCode,contacter,telephone,fax,intype,isinvoice,remarks};
			int ret=stock.addDataStIn(obj);
			
			
			
			List<StockIn> list=new ArrayList<StockIn>();
			list=stock.findDataStInByCode(code);
			JsonConfig config=new JsonConfig();
			config.registerJsonValueProcessor(Date.class,new JSONDateProcessor("yyyy-MM-dd"));
			Map attrs =new HashMap();
			JSONObject jsonObj=new JSONObject();
			attrs.put("rows", list);
			jsonObj.putAll(attrs,config);
			String data=jsonObj.toString();	
			response.getWriter().println(data);
		}
		
		
		
		
		if(opt.equals("2")){
			String incode=request.getParameter("incode");
			List<StockInDetail> listdetail=new ArrayList<StockInDetail>();
			listdetail=stock.findDataStInDetailByIncode(incode);
			
			JsonConfig config=new JsonConfig();
			config.registerJsonValueProcessor(Date.class,new JSONDateProcessor("yyyy-MM-dd"));
			Map attrs =new HashMap();
			JSONObject jsonObj=new JSONObject();
			attrs.put("rows",listdetail);
			jsonObj.putAll(attrs,config);
			String data=jsonObj.toString();	
			System.out.println(data);
			response.getWriter().println(data);
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
}