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
		HSSFWorkbook workbook = new HSSFWorkbook();//����һ��Excel�ļ�
		HSSFSheet sheet = workbook.createSheet("���˵�����");//���һ��sheet
		
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle cellStyle = workbook.createCellStyle();//������Ԫ�񣬲�����ֵ��ͷ���ñ�ͷ���� 
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//ˮƽ����
		HSSFCell cell = row.createCell(0);  
        cell.setCellValue("�������");  
        cell.setCellStyle(cellStyle);  
        cell = row.createCell(1);  
        cell.setCellValue("��������");  
        cell.setCellStyle(cellStyle);  
        cell = row.createCell(2);  
        cell.setCellValue("�ͻ�����");  
        cell.setCellStyle(cellStyle);  
        cell = row.createCell(3);  
        cell.setCellValue("����");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(4);  
        cell.setCellValue("���˽��");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(5);  
        cell.setCellValue("��ϵ��");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(6);  
        cell.setCellValue("��ϵ��ʽ");
        cell = row.createCell(7);  
        cell.setCellValue("���״̬");
        cell = row.createCell(8);  
        cell.setCellValue("����Ա");
        cell = row.createCell(9);  
        
        cell.setCellStyle(cellStyle); 
        //д��ʵ�����ݣ�ʵ������Щ����Ӧ�ô����ݿ�õ�
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
        FileOutputStream fout = new FileOutputStream("E://���˵�����.xls");  
        workbook.write(fout);  
        fout.close();
       
        response.sendRedirect("/ERP/erpSystem/SaleReturnManagement.jsp");
	
	}

}
