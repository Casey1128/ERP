package com.erp.basic.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
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

import com.erp.basic.entity.basecusTomerSipplier;
import com.erp.utils.PageBean;

public class PrintToExcelServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PrintToExcelServlet() {
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

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		List<basecusTomerSipplier> list = new ArrayList<basecusTomerSipplier>();
		PageBean pageBean=new PageBean();
		pageBean=(PageBean)request.getSession().getAttribute("Bean");
		list=pageBean.getData();
		HSSFWorkbook workbook = new HSSFWorkbook();//创建一个Excel文件
		HSSFSheet sheet = workbook.createSheet("字典信息表");//添加一个sheet
		
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle cellStyle = workbook.createCellStyle();//创建单元格，并设置值表头设置表头居中 
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
		HSSFCell 
        cell = row.createCell(0);  
        cell.setCellValue("代码");  
        cell.setCellStyle(cellStyle);  
        cell = row.createCell(1);  
        cell.setCellValue("公司名称");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(2);  
		cell.setCellValue("类别");  
        cell.setCellStyle(cellStyle);
        cell = row.createCell(3);  
        cell.setCellValue("联系人");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(4);  
        cell.setCellValue("电话");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(5);  
        cell.setCellValue("地址");  
        cell.setCellStyle(cellStyle);      
        cell = row.createCell(6);  
        cell.setCellValue("显示状态");  
        cell.setCellStyle(cellStyle); 
        //写入实体数据，实际上这些数据应该从数据库得到
        String show="";
        for(int i = 0; i < list.size(); i++)  
        {  
        	basecusTomerSipplier bSipplier=list.get(i);
            row = sheet.createRow(i+1);  
            
            row.createCell(0).setCellValue(bSipplier.getCode());  
            row.createCell(1).setCellValue(bSipplier.getCsName()); 
            row.createCell(2).setCellValue(bSipplier.getCategorycode()); 
            row.createCell(3).setCellValue(bSipplier.getContacter()); 
           
            row.createCell(4).setCellValue(bSipplier.getTelephone()); 
            row.createCell(5).setCellValue(bSipplier.getAddress()); 
           // row.createCell(6).setCellValue(bSipplier.getIsShow()); 
            String ret=bSipplier.getIsShow();
            if(ret==null||ret==""){
            	ret="2";
            }
           if(ret.equals("1")){
            	show="显示";
            }else{
            	show="隐藏";
            }
            row.createCell(6).setCellValue(show); 
        }
        FileOutputStream fout = new FileOutputStream("E://客户信息往来管理.xls");  
        workbook.write(fout);  
        fout.close(); 
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
