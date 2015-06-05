package com.erp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SysTools {
	public static String CreateCode(String head){
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
		String code=head+sdf.format(date);
		return code;
	}
	public static void main(String[] args) {
		SysTools st=new SysTools();
		String code=st.CreateCode("ST");
		System.out.println(code);
	}

}
