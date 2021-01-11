package com.myself.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具
 * 
 * @author Adolph
 * 
 */
public class DateUtils {

	// 各种时间格式
//	public static final SimpleDateFormat date_sdf = new SimpleDateFormat(
//			"yyyy-MM-dd");
	public static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat(
			"yyyyMMdd");
	public static final SimpleDateFormat date_sdf_wz = new SimpleDateFormat(
			"yyyy年MM月dd日");
//	public static final SimpleDateFormat time_sdf = new SimpleDateFormat(
//			"yyyy-MM-dd HH:mm");
	public static final SimpleDateFormat yyyymmddhhmmss = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	public static final SimpleDateFormat short_time_sdf = new SimpleDateFormat(
			"HH:mm");
	public static final SimpleDateFormat datetimeFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 当前日历，这里用中国时间表示
	 * @return
	 */
	public static Calendar getCalendar() {
		return Calendar.getInstance();
	}

	/**
	 * 获取yyyy-MM-dd格式日期
	 * 
	 * @return
	 */
	public static String getNowDate() {
		SimpleDateFormat date_sdf = new SimpleDateFormat(
		"yyyy-MM-dd");
		Date date = new Date();
		return date_sdf.format(date);
	}

	/**
	 * 时间格式化
	 * 
	 * @param date
	 * @return
	 */
	public static String formatyyyyMMddHHmm(Date date) {
		SimpleDateFormat time_sdf = new SimpleDateFormat(
		"yyyy-MM-dd HH:mm");
		return time_sdf.format(date);
	}
	
	/**
	 * 获取当前时间
	 * 2015-2-7 17:00
	 * @param date
	 * @return
	 */
	public static String getTime(Date date) {
		SimpleDateFormat time_sdf = new SimpleDateFormat(
		"yyyy-MM-dd HH:mm");
		return time_sdf.format(date);
	}
	
	/**
	 * 日期大小比较
	 * @param date1
	 * @param date2
	 * @return 1: date1> date2,-1:date1<date2 ,0:date1=date2,-2 异常
	 */
	public static int compare(String date1,String date2){
		SimpleDateFormat time_sdf = new SimpleDateFormat(
		"yyyy-MM-dd HH:mm");
		try {
			//为空或null 返回-2
			if((null == date1 || "".equals(date1)) || (null == date2 || "".equals(date2))) {
				return 0;
			}
			Date dt1 = time_sdf.parse(date1);
			Date dt2 = time_sdf.parse(date2);
			if(dt1.getTime() > dt2.getTime()) {
				return 1;
			}else if(dt1.getTime() < dt2.getTime()) {
				return -1;
			}else {
				return 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * date2 是否超出date1 24个小时
	 * @param date1
	 * @param date2
	 * @return true ,false
	 */
	public static boolean ifOut24(String date1,String date2) {
		SimpleDateFormat time_sdf = new SimpleDateFormat(
		"yyyy-MM-dd HH:mm");
		try {
			//为空或null 返回false
			if((null == date1 || "".equals(date1)) || (null == date2 || "".equals(date2))) {
				return false;
			}
			Date dt1 = time_sdf.parse(date1);
			Date dt2 = time_sdf.parse(date2);
			long size = dt2.getTime() - dt1.getTime();
			double result = size * 1.0/(1000*60*60);
			//小于等于24小时
			if(result <= 24.0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
