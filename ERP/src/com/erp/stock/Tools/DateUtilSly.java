package com.erp.stock.Tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtilSly {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
	private static SimpleDateFormat longFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	private static SimpleDateFormat chFormat = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
	private static SimpleDateFormat chFormat2 = new SimpleDateFormat("yyyy��MM��dd�� E");
	private static SimpleDateFormat OracleDate=new SimpleDateFormat("dd-M��-yyyy");

	public static Date toDate(String strDate) {
		Date date = null;
		try {
			date = dateFormat.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;

	}

	public static String toFormatDate(long time) {
		return chFormat.format(new Date(time));
	}

	public static String toFormatDate(Date date) {
		return chFormat.format(date);
	}

	public static String toFormatDateWithWeek(Date date) {
		return chFormat2.format(date);
	}

	public static long getTime() {
		return new Date().getTime();
	}
	
	public static Date toOracleDate(String strDate) throws ParseException{
		return OracleDate.parse(strDate);
	}
	public static String toOracleString(Date date){
		return OracleDate.format(date);
	}
	public static String getNamedByTime() {
		Calendar c = Calendar.getInstance();
		String name = c.get(Calendar.YEAR) + "" + c.get(Calendar.MONTH) + ""
				+ c.get(Calendar.DAY_OF_MONTH) + c.get(Calendar.HOUR) + ""
				+ c.get(Calendar.MINUTE) + "" + c.get(Calendar.SECOND);
		return name;

	}
	

}