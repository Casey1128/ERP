package com.erp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UnitCode {
	public String getUnitCode(){
		
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		String code=sdf.format(date);
		code="KGS"+code;
		
		return code;
		
	}
	public String getUnitTime(){
		
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time=sdf.format(date);
		
		
		return time;
		
	}
	public static void main(String[] args) {
		UnitCode unitCode=new UnitCode();
		String code=unitCode.getUnitCode();
		String time=unitCode.getUnitTime();
		System.out.println(code);
		System.out.println(time);
	}

}
