package com.minghui.util.utils;

import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * 
 * @author zengjk 2017-07-21 15:37:45
 */
public class DateUtil {

	private static final String DATE_FORMAT = "yyyy-MM-dd";
	private static final String DATE_FORMAT_T = "yyMMdd";
	private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final String DATE_TIME_NOS_FORMAT = "yyyy-MM-dd HH:mm";
	private static final String TIME_FORMAT = "HHmmss";
	private static final String TIME_SEMICOLON_FORMAT = "HH:mm:ss";

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static Date getNowTime() {
		return new Date();
	}

	/**
	 * 获取当前时间字符串 格式:yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getCurrentTime() {
		return getDateTimeStr(new Date());
	}

	/**
	 * 获取指定时间字符串 格式:yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateTimeStr(Date date) {
		if (date == null) {
			return null;
		}
		DateFormat sdf = getDateTimeFormat();
		return sdf.format(date);
	}

	/**
	 * 转换获取时间，指定时间字符串 格式:yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date getDateTime(String dateStr) {
		if (StringUtils.isEmpty(dateStr)) {
			return null;
		}
		DateFormat sdf = getDateTimeFormat();
		ParsePosition pos = new ParsePosition(0);
		return sdf.parse(dateStr, pos);
	}

	/**
	 * 获取指定时间字符串 格式:yyyy-MM-dd HH:mm
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateTimeNosStr(Date date) {
		if (date == null) {
			return null;
		}
		DateFormat sdf = getDateTimeNosFormat();
		return sdf.format(date);
	}

	/**
	 * 转换获取时间，指定时间字符串 格式:yyyy-MM-dd HH:mm
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date getDateTimeNos(String dateStr) {
		if (StringUtils.isEmpty(dateStr)) {
			return null;
		}
		DateFormat sdf = getDateTimeNosFormat();
		ParsePosition pos = new ParsePosition(0);
		return sdf.parse(dateStr, pos);
	}

	/**
	 * 获取指定日期字符串 格式:yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateStr(Date date) {
		if (date == null) {
			return null;
		}
		DateFormat df = getDateFormat();
		return df.format(date);
	}

	/**
	 * 转换获取时间，指定时间字符串 格式:yyyy-MM-dd
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date getDateTimeYMd(String dateStr) {
		if (StringUtils.isEmpty(dateStr)) {
			return null;
		}
		DateFormat sdf = getDateFormat();
		ParsePosition pos = new ParsePosition(0);
		return sdf.parse(dateStr, pos);
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateStrYYMMDD(Date date) {
		if (date == null) {
			return null;
		}
		DateFormat df = getDateFormatT();
		return df.format(date);
	}

	/**
	 * 获取指定时间字符串 格式:HHmmss
	 * 
	 * @param date
	 * @return
	 */
	public static String getTimeStr(Date date) {
		if (date == null) {
			return null;
		}
		DateFormat df = getTimeFormat();
		return df.format(date);
	}

	/**
	 * 获取指定时间字符串 格式:HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String getTimeSemicolonStr(Date date) {
		if (date == null) {
			return null;
		}
		DateFormat df = getTimeSemicolonFormat();
		return df.format(date);
	}

	private static ThreadLocal<DateFormat> dateTimeThreadLocal = new ThreadLocal<DateFormat>();

	public static DateFormat getDateTimeFormat() {
		DateFormat df = (DateFormat) dateTimeThreadLocal.get();
		if (df == null) {
			df = new SimpleDateFormat(DATE_TIME_FORMAT);
			dateTimeThreadLocal.set(df);
		}
		return df;
	}

	private static ThreadLocal<DateFormat> dateTimeNosThreadLocal = new ThreadLocal<DateFormat>();

	public static DateFormat getDateTimeNosFormat() {
		DateFormat df = (DateFormat) dateTimeNosThreadLocal.get();
		if (df == null) {
			df = new SimpleDateFormat(DATE_TIME_NOS_FORMAT);
			dateTimeNosThreadLocal.set(df);
		}
		return df;
	}

	private static ThreadLocal<DateFormat> dateThreadLocal = new ThreadLocal<DateFormat>();

	public static DateFormat getDateFormat() {
		DateFormat df = (DateFormat) dateThreadLocal.get();
		if (df == null) {
			df = new SimpleDateFormat(DATE_FORMAT);
			dateThreadLocal.set(df);
		}
		return df;
	}

	public static DateFormat getDateFormatT() {
		DateFormat df = (DateFormat) dateThreadLocal.get();
		if (df == null) {
			df = new SimpleDateFormat(DATE_FORMAT_T);
			dateThreadLocal.set(df);
		}
		return df;
	}

	private static ThreadLocal<DateFormat> timeThreadLocal = new ThreadLocal<DateFormat>();

	public static DateFormat getTimeFormat() {
		DateFormat df = (DateFormat) timeThreadLocal.get();
		if (df == null) {
			df = new SimpleDateFormat(TIME_FORMAT);
			timeThreadLocal.set(df);
		}
		return df;
	}

	private static ThreadLocal<DateFormat> timeSemicolonThreadLocal = new ThreadLocal<DateFormat>();

	public static DateFormat getTimeSemicolonFormat() {
		DateFormat df = (DateFormat) timeSemicolonThreadLocal.get();
		if (df == null) {
			df = new SimpleDateFormat(TIME_SEMICOLON_FORMAT);
			timeSemicolonThreadLocal.set(df);
		}
		return df;
	}

	/**
	 * 获取时间差 秒级
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public static String getTimeSpace(Date begin, Date end) {
		try {
			long between = (end.getTime() - begin.getTime());// 除以1000是为了转换成秒
			long day1 = between / 1000 / (24 * 3600);
			long hour1 = between / 1000 % (24 * 3600) / 3600;
			long minute1 = between / 1000 % 3600 / 60;
			long second1 = between / 1000 % 60;
			long ms = between % 60 % 1000;
			return "" + day1 + "天" + hour1 + "小时" + minute1 + "分" + second1 + "秒" + ms + "毫秒";
		} catch (Exception pe) {
			return null;
		}
	}

	/**
	 * 日期比较 yyyy-MM-dd
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static boolean dateEquals(Date d1, Date d2) {
		if (d1 == null && d2 == null)
			return true;
		else if ((d1 == null && d2 != null) || (d1 != null && d1 == null))
			return false;
		else
			return getDateStr(d1).equals(getDateStr(d2));
	}

	/**
	 * 根据时间得到星期
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeekCurrent(Date date) {
		String[] weekDays = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
		if (date == null) {
			date = new Date();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}

	/**
	 * 根据某个日期获取N天/月/年的前/后的日期 CalendarTimeType类型：Calendar.DATE,
	 * Calendar.MONTH,Calendar.YEAR 等
	 * 
	 * @author cmh
	 * @param date
	 * @param num
	 * @return
	 */
	public static Date getBfOrAfNumDate(Date date, int calendarTimeType, int num, boolean beforeDate) {
		if (date == null) {
			return null;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if (beforeDate) {
			num = -num;
		}
		cal.add(calendarTimeType, num);
		return cal.getTime();
	}

	/**
	 * 获取指定年月的第一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getFirstDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		if (year > 0) {
			// 设置年份
			cal.set(Calendar.YEAR, year);
		}
		if (month > 0) {
			// 设置月份
			cal.set(Calendar.MONTH, month - 1);
		}
		// 获取某月最小天数
		int firstDay = cal.getMinimum(Calendar.DATE);
		// 设置日历中月份的最小天数
		cal.set(Calendar.DAY_OF_MONTH, firstDay);
		return getDateFormat().format(cal.getTime());
	}

	/**
	 * 设置日期增加天数
	 * 
	 * @param dateSub
	 * @return
	 * @author cwp 2018年11月2日 下午5:47:46
	 */
	public static String getDaySub(int dateSub) {
		Calendar cal = Calendar.getInstance();
		// 设置日历中日期增加天数
		cal.add(Calendar.DAY_OF_MONTH, dateSub);
		return getDateFormat().format(cal.getTime());
	}

	/**
	 * 获取指定年月的最后一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		if (year > 0) {
			// 设置年份
			cal.set(Calendar.YEAR, year);
		}
		if (month > 0) {
			// 设置月份
			cal.set(Calendar.MONTH, month - 1);
		}
		// 获取某月最大天数
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		// 设置日历中月份的最大天数
		cal.set(Calendar.DAY_OF_MONTH, lastDay);
		return getDateFormat().format(cal.getTime());
	}

	public static int getCurrentYear() {
		Calendar date = Calendar.getInstance();
		return date.get(Calendar.YEAR);
	}

	public static int getCurrentMonth() {
		Calendar date = Calendar.getInstance();
		return date.get(Calendar.MONTH) + 1;
	}

	public static void main(String[] args) {
		int i = 0;
		System.out.println(i);
		System.out.println(DateUtil.getFirstDayOfMonth(2018, 9));
	}

	/**
	 * 根据出生日期获取年龄,精确到天
	 * 
	 * @author CPY 2018年11月30日17:06:17
	 * @param birthday
	 *            出生日期 格式 yyyy-MM-dd
	 * @return String
	 */
	public static String getAge(String birthday) {
		Date date = getDateTimeYMd(birthday);
		Calendar calendar = Calendar.getInstance();
		int yearNow = calendar.get(Calendar.YEAR);
		int monthNow = calendar.get(Calendar.MONTH) + 1;
		int dayNow = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.setTime(date);
		int yearBirth = calendar.get(Calendar.YEAR);
		int monthBirth = calendar.get(Calendar.MONTH) + 1;
		int dayBirth = calendar.get(Calendar.DAY_OF_MONTH);
		int age = yearNow - yearBirth;
		if (monthNow <= monthBirth && monthNow == monthBirth && dayNow < dayBirth) {
			age--;
		} else if (monthNow < monthBirth) {
			age--;
		}
		return String.valueOf(age);
	}

	/**
	 * 获取三十天前日期
	 * 
	 * @return Date
	 * @author YMH
	 * @date 2019/04/13 17:57
	 */
	public static Date getDateMonthBefore() {
		Calendar theCa = Calendar.getInstance();
		Date today = new Date();
		theCa.setTime(today);
		theCa.add(Calendar.DATE, -30);
		return theCa.getTime();
	}

	/**
	 * 获取一年前日期
	 * 
	 * @return Date
	 * @author YMH
	 * @date 2019/04/13 17:57
	 */
	public static Date getDateOneYearBefore() {
		Calendar theCa = Calendar.getInstance();
		Date today = new Date();
		theCa.setTime(today);
		theCa.add(Calendar.YEAR, -1);
		return theCa.getTime();
	}

	/**
	 * 获取相隔几天的日期
	 * 
	 * @param dateBefore
	 * @return
	 * @author cwp 2019年4月28日 上午11:24:54
	 */
	public static Date getDateByDayDif(int dateBefore) {
		Calendar theCa = Calendar.getInstance();
		Date today = new Date();
		theCa.setTime(today);
		theCa.add(Calendar.DATE, dateBefore);
		return theCa.getTime();
	}

	/**
	 * 获取昨天日期
	 * 
	 * @return Date
	 * @author YMH
	 * @date 2019/04/13 17:57
	 */
	public static Date getYesterday() {
		Calendar theCa = Calendar.getInstance();
		Date today = new Date();
		theCa.setTime(today);
		theCa.add(Calendar.DATE, -1);
		return theCa.getTime();
	}

	/**
	 * 获取当天的起始时间
	 * @return
	 * @author YMH
	 * @date 2019/5/22 18:09
	 */
	public static Date getBeginTime(){
		Calendar theCa = Calendar.getInstance();
		Date today = new Date();
		theCa.setTime(today);
		theCa.set(Calendar.HOUR_OF_DAY,0);
		theCa.set(Calendar.MINUTE,0);
		theCa.set(Calendar.SECOND,0);
		return theCa.getTime();


	}

}
