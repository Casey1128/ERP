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

import com.erp.basic.entity.BaseCompany;
import com.erp.basic.entity.BaseContent;
import com.erp.utils.PageBean;

public class PrintToExcelServlet1 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PrintToExcelServlet1() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		List<BaseCompany> list = new ArrayList<BaseCompany>();
		PageBean pageBean=new PageBean();
		pageBean=(PageBean)request.getSession().getAttribute("Bean");
		list=pageBean.getData();
		HSSFWorkbook workbook = new HSSFWorkbook();//创建一个Excel文件
		HSSFSheet sheet = workbook.createSheet("字典信息表");//添加一个sheet
		
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle cellStyle = workbook.createCellStyle();//创建单元格，并设置值表头设置表头居中 
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
		HSSFCell cell = row.createCell(0);  
        cell.setCellValue("所属类别");  
        cell.setCellStyle(cellStyle);  
        cell = row.createCell(1);  
        cell.setCellValue("字典编号");  
        cell.setCellStyle(cellStyle);  
        cell = row.createCell(2);  
        cell.setCellValue("字典内容");  
        cell.setCellStyle(cellStyle);  
        cell = row.createCell(3);  
        cell.setCellValue("公司名称");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(4);  
        cell.setCellValue("排序编号");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(5);  
        cell.setCellValue("备注");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(6);  
        cell.setCellValue("操作员");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(7);  
        cell.setCellValue("显示状态");  
        cell.setCellStyle(cellStyle); 
        //写入实体数据，实际上这些数据应该从数据库得到
        String show="";
        for(int i = 0; i < list.size(); i++)  
        {  
        	BaseCompany baseCompany=list.get(i);
            row = sheet.createRow(i+1);  
            row.createCell(0).setCellValue(baseCompany.getBaseContent().getCategoryCode());  
            row.createCell(1).setCellValue(baseCompany.getBaseContent().getCode());  
            row.createCell(2).setCellValue(baseCompany.getBaseContent().getCodeName()); 
            row.createCell(3).setCellValue(baseCompany.getCompName()); 
            row.createCell(4).setCellValue(baseCompany.getBaseContent().getOrderNo()); 
            row.createCell(5).setCellValue(baseCompany.getBaseContent().getRemarks()); 
            row.createCell(6).setCellValue(baseCompany.getBaseContent().getAddUser()); 
            
            if(baseCompany.getBaseContent().getIsShow()==1){
            	show="显示";
            }else{
            	show="隐藏";
            }
            row.createCell(7).setCellValue(show); 
        }
        FileOutputStream fout = new FileOutputStream("E://字典信息管理.xls");  
        workbook.write(fout);  
        fout.close();   

	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
