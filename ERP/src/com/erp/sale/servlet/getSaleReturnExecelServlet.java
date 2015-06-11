package com.erp.sale.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import com.erp.sale.entity.SaleReturn;
import com.erp.utils.PageBean;

public class getSaleReturnExecelServlet extends HttpServlet {

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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		List<SaleReturn> list = new ArrayList<SaleReturn>();
		PageBean pageBean=new PageBean();
		pageBean=(PageBean)request.getSession().getAttribute("Bean");
		list=pageBean.getData();
		HSSFWorkbook workbook = new HSSFWorkbook();//创建一个Excel文件
		HSSFSheet sheet = workbook.createSheet("销退单报表");//添加一个sheet
		
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle cellStyle = workbook.createCellStyle();//创建单元格，并设置值表头设置表头居中 
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
		HSSFCell cell = row.createCell(0);  
        cell.setCellValue("订单编号");  
        cell.setCellStyle(cellStyle);  
        cell = row.createCell(1);  
        cell.setCellValue("订单日期");  
        cell.setCellStyle(cellStyle);  
        cell = row.createCell(2);  
        cell.setCellValue("客户名称");  
        cell.setCellStyle(cellStyle);  
        cell = row.createCell(3);  
        cell.setCellValue("数量");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(4);  
        cell.setCellValue("销退金额");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(5);  
        cell.setCellValue("联系人");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(6);  
        cell.setCellValue("联系方式");
        cell = row.createCell(7);  
        cell.setCellValue("审核状态");
        cell = row.createCell(8);  
        cell.setCellValue("操作员");
        cell = row.createCell(9);  
        
        cell.setCellStyle(cellStyle); 
        //写入实体数据，实际上这些数据应该从数据库得到
        String show="";
        for(int i = 0; i < list.size(); i++)  
        {  
        	SaleReturn saleReturn=list.get(i);
            row = sheet.createRow(i+1);  
            row.createCell(0).setCellValue(saleReturn.getCode());  
            row.createCell(1).setCellValue(saleReturn.getXtDate());  
            row.createCell(2).setCellValue(saleReturn.getCustomerCode()); 
            row.createCell(3).setCellValue(saleReturn.getNums()); 
            row.createCell(4).setCellValue(saleReturn.getNumsPrice()); 
            row.createCell(5).setCellValue(saleReturn.getContacter()); 
            row.createCell(6).setCellValue(saleReturn.getTelphone());
            row.createCell(7).setCellValue(saleReturn.getState());
            row.createCell(8).setCellValue(saleReturn.getAddUserName());
            
            
        }
        FileOutputStream fout = new FileOutputStream("E://销退单管理.xls");  
        workbook.write(fout);  
        fout.close();
       
        response.sendRedirect("/ERP/erpSystem/SaleReturnManagement.jsp");
	
	}

}
