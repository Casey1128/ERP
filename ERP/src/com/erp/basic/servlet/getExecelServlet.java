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

import com.erp.basic.entity.Baseparts;
import com.erp.utils.PageBean;

public class getExecelServlet extends HttpServlet {

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
		List<Baseparts> list = new ArrayList<Baseparts>();
		PageBean pageBean=new PageBean();
		pageBean=(PageBean)request.getSession().getAttribute("Bean");
		list=pageBean.getData();
		HSSFWorkbook workbook = new HSSFWorkbook();//����һ��Excel�ļ�
		HSSFSheet sheet = workbook.createSheet("�����Ϣ����");//���һ��sheet
		
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle cellStyle = workbook.createCellStyle();//������Ԫ�񣬲�����ֵ��ͷ���ñ�ͷ���� 
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//ˮƽ����
		HSSFCell cell = row.createCell(0);  
        cell.setCellValue("�������");  
        cell.setCellStyle(cellStyle);  
        cell = row.createCell(1);  
        cell.setCellValue("�������");  
        cell.setCellStyle(cellStyle);  
        cell = row.createCell(2);  
        cell.setCellValue("������");  
        cell.setCellStyle(cellStyle);  
        cell = row.createCell(3);  
        cell.setCellValue("�������");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(4);  
        cell.setCellValue("���Ʒ��");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(5);  
        cell.setCellValue("����ͺ�");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(6);  
        cell.setCellValue("������ͺ�");
        cell = row.createCell(7);  
        cell.setCellValue("������ۼ۸�");
        cell = row.createCell(8);  
        cell.setCellValue("��ʾ״̬");
        cell = row.createCell(9);  
        cell.setCellValue("����Ա");
        cell = row.createCell(10);  
        cell.setCellValue("��ע");
        cell.setCellStyle(cellStyle); 
        //д��ʵ�����ݣ�ʵ������Щ����Ӧ�ô����ݿ�õ�
        String show="";
        for(int i = 0; i < list.size(); i++)  
        {  
        	Baseparts baseparts=list.get(i);
            row = sheet.createRow(i+1);  
            row.createCell(0).setCellValue(baseparts.getPartsCode());  
            row.createCell(1).setCellValue(baseparts.getPartsGeneralpartsno());  
            row.createCell(2).setCellValue(baseparts.getPartsCategory()); 
            row.createCell(3).setCellValue(baseparts.getPartsName()); 
            row.createCell(4).setCellValue(baseparts.getPartsBrand()); 
            row.createCell(5).setCellValue(baseparts.getPartsModel()); 
            row.createCell(6).setCellValue(baseparts.getPartsModelOld());
            row.createCell(7).setCellValue(baseparts.getSalePrice());
            row.createCell(8).setCellValue(baseparts.getIsShow());
            row.createCell(9).setCellValue(baseparts.getAddUserName());
            row.createCell(10).setCellValue(baseparts.getRemarks());
            
        }
        FileOutputStream fout = new FileOutputStream("E://�����Ϣ����.xls");  
        workbook.write(fout);  
        fout.close();
       
        response.sendRedirect("/ERP/console/baseparts/basepartsList.jsp");

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
		this.doPost(request, response);
		
	}

}
