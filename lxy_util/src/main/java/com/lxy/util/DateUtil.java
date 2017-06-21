package com.lxy.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static long nd = 1000 * 24 * 60 * 60; // 一天的毫秒数
	public static long nh = 1000 * 60 * 60; // 一小时的毫秒数
	public static long nm = 1000 * 60; // 一分钟的毫秒数
	public static long ns = 1000; // 一秒钟的毫秒数
	public static final String DATE_PATTERN = "yyyy-MM-dd";
	public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String TIME_PATTERN = "HH:mm:ss";

	public static final String DATE_PATTERN_1 = "yyyy年MM月dd日 HH:mm";

	public static Long parseDate(String s,String pattern) {
		SimpleDateFormat ds = new SimpleDateFormat(pattern);
		try {
			Date date = ds.parse(s);
			return date.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}


}
