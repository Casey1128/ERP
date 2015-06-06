package com.erp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class saleOrderCode {
	public static String CreateOrderCode(String head){
		Date time=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		String date=sdf.format(time);
		String code=head+date;
		return code;
	}
	
	public static void main(String[] args){
		saleOrderCode order=new saleOrderCode();
		String head="MTXS";
		String code=order.CreateOrderCode(head);
		System.out.println(code);
	}
}
