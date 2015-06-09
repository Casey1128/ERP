package com.part.servlet;

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

import com.erp.stock.entity.StockIn;
import com.erp.stock.service.StockInService;
import com.erp.stock.service.Impl.StockInServiceImpl;
import com.erp.utils.PageBean;





public class StockInPortExcel extends HttpServlet {

	public StockInPortExcel() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		List<StockIn> list = new ArrayList<StockIn>();
		PageBean pageBean=new PageBean();
		StockInService stock=new StockInServiceImpl();;
		pageBean= stock.findAllDataStIn(1,100);
		list=pageBean.getData();
		HSSFWorkbook workbook = new HSSFWorkbook();//����һ��Excel�ļ�
		HSSFSheet sheet = workbook.createSheet("������Ϣ��");//���һ��sheet
		
		HSSFRow row = sheet.createRow(0);
		HSSFCellStyle cellStyle = workbook.createCellStyle();//������Ԫ�񣬲�����ֵ��ͷ���ñ�ͷ���� 
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);//ˮƽ����
		HSSFCell 
        cell = row.createCell(0);  
        cell.setCellValue("��ⵥ��");  
        cell.setCellStyle(cellStyle);  
        cell = row.createCell(1);  
        cell.setCellValue("�������");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(2);  
		cell.setCellValue("��Ӧ����");  
        cell.setCellStyle(cellStyle);
        cell = row.createCell(3);  
        cell.setCellValue("����");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(4);  
        cell.setCellValue("�ܻ�ֵ");  
        cell.setCellStyle(cellStyle); 
        cell = row.createCell(5);  
        cell.setCellValue("���״̬");  
        cell.setCellStyle(cellStyle);      
        cell = row.createCell(6);  
        cell.setCellValue("����Ա");  
        cell.setCellStyle(cellStyle); 
        //д��ʵ�����ݣ�ʵ������Щ����Ӧ�ô����ݿ�õ�
        String show="";
        for(int i = 0; i < list.size(); i++)  
        {  
        	StockIn bSipplier=list.get(i);
            row = sheet.createRow(i+1);  
            
            row.createCell(0).setCellValue(bSipplier.getCode());  
            row.createCell(1).setCellValue(bSipplier.getIndate()); 
            row.createCell(2).setCellValue(bSipplier.getContacter()); 
            row.createCell(3).setCellValue(bSipplier.getNums()); 
           
            row.createCell(4).setCellValue(bSipplier.getNumsPrice()); 
            row.createCell(5).setCellValue(bSipplier.getState()); 
            System.out.println(bSipplier.getAddUserName());

        }
        
        FileOutputStream fout = new FileOutputStream("E:/�������.xls");  
        workbook.write(fout);  
        fout.close(); 
        response.sendRedirect("/ERP/erpStock/StockIn/StockIn.jsp");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
