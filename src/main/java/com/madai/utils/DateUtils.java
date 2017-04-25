package com.madai.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;

public class DateUtils {

	public static final String YEAR_MONTH_DAY_PATTERN = "yyyy-MM-dd";

	/**
	 * 计算相差月份
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int calculateMonth(Date startDate, Date endDate) {
		if(startDate==null || endDate==null){
			return 0;
		}else{
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(startDate);
		c2.setTime(endDate);

		int year1 = c1.get(Calendar.YEAR);
		int month1 = c1.get(Calendar.MONTH);

		int year2 = c2.get(Calendar.YEAR);
		int month2 = c2.get(Calendar.MONTH);

		int result;
		if (year2 == year1) {
			result = month2 - month1;// 两个日期相差几个月，即月份差
		} else {
			result = 12 * (year2 - year1) + (month2 - month1);// 两个日期相差几个月，即月份差
		}
		return Math.abs(result);
		}
	}

	/**
	 * 根据传入的日期格式化patter将传入的字符串转换成日期对象
	 * 
	 * @param dateStr
	 *            要转换的字符串
	 * @param pattern
	 *            日期格式化pattern
	 * @return 转换后的日期对象
	 * @throws ParseException
	 *             如果传入的字符串格式不合法
	 */
	public static Date parse(final String dateStr, final String pattern) throws ParseException {
		if (StringUtils.isEmpty(dateStr)) {
			return null;
		}
		DateFormat df = new SimpleDateFormat(pattern);
		return df.parse(dateStr);
	}
	
	public static String dateToStr(Date date,String pattern){
		if(date == null){
			return "";
		}
		DateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}
	
	public static String dateToStr(Date date){
		return dateToStr(date, YEAR_MONTH_DAY_PATTERN);
	}

	public static void main(String[] args) throws ParseException {
		Date startDate = parse("2016-07-21", YEAR_MONTH_DAY_PATTERN);
		Date endDate = parse("2016-07-21", YEAR_MONTH_DAY_PATTERN);
		System.out.println(calculateMonth(startDate, endDate));
	}
}
