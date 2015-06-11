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

import com.erp.basic.entity.BasePartsCategory;
import com.erp.sale.entity.saleOrder;
import com.erp.utils.PageBean;

public class ExportOrderDataServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ExportOrderDataServlet() {
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		List<saleOrder> list = new ArrayList<saleOrder>();
		PageBean pageBean=new PageBean();
		pageBean=(PageBean)request.getSession().getAttribute("orderBean");
		list=pageBean.getData();
		HSSFWorkbook workbook = new HSSFWorkbook();//����һ��Excel�ļ�
		HSSFSheet sheet = workbook.createSheet("������ѯ����");//���һ��sheet
		
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
        cell.setCellValue("�ܻ�ֵ");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(5);  
        cell.setCellValue("��ϵ��");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(6);  
        cell.setCellValue("��ϵ��ʽ");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(7);  
        cell.setCellValue("���״̬");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(8);  
        cell.setCellValue("����Ա");  
        cell.setCellStyle(cellStyle); 
      
        
        //д��ʵ�����ݣ�ʵ������Щ����Ӧ�ô����ݿ�õ�
        String show="";
        for(int i = 0; i < list.size(); i++)  
        {  
        	saleOrder parts=list.get(i);
            row = sheet.createRow(i+1);  
            row.createCell(0).setCellValue(parts.getCode());  
            row.createCell(1).setCellValue(parts.getOrderDate().toString());  
            row.createCell(2).setCellValue(parts.getCustomercode()); 
            row.createCell(3).setCellValue(parts.getNums()); 
            row.createCell(4).setCellValue(parts.getTotal()); 
            row.createCell(5).setCellValue(parts.getContacter()); 
            row.createCell(6).setCellValue(parts.getTelphone()); 
            if(parts.getState().equals("1")){
            	show="�����";
            }else{
            	show="δ���";
            }
            row.createCell(7).setCellValue(show); 
            row.createCell(8).setCellValue(parts.getAddUser()); 
        }
        
        FileOutputStream fout = new FileOutputStream("E://������ѯ����.xls");  
        workbook.write(fout);  
        fout.close();   
        response.sendRedirect("../erpSystem/orderManagement.jsp");
	}

}
