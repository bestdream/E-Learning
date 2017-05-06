package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static Date parseStr(String formatDate,String date) throws ParseException{
		if(StringUtil.isNull(date))return null;
		return new SimpleDateFormat(formatDate).parse(date);
	}
	
	public static String formatDate(String formatDate,Date date) throws ParseException{
		if(StringUtil.isNull(date))return "";
		return new SimpleDateFormat(formatDate).format(date);
	}
	
	public static String parseStr(String formatStr,String formatDate,String date) throws ParseException{
		return new SimpleDateFormat(formatDate).format(new SimpleDateFormat(formatStr).parse(date));
	}
	
	public static Long diffDate(Date d1,Date d2){
		return (d2.getTime()-d1.getTime())/1000;
	}
	
	public static int getMonthDay(int year, int month) {
		int result = 0;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			result = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			result = 30;
			break;
		case 2:
			result = 28;
			if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
				result = 29;
			}
			break;
		}

		return result;
	}

	public static int getMonthDays(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);

		return cal.getActualMaximum(Calendar.DATE);
	}
	//获取年份
	public static int getyear(Date year){
		Calendar cld = Calendar.getInstance();
		Date date = year;
		cld.setTime(date);
		cld.get(Calendar.YEAR);
		return  cld.get(Calendar.YEAR);
	}
	
	public static String defFormatDate(Date date) throws ParseException{
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

}
