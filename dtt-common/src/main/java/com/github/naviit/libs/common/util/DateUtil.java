/************************************************
 * Copyright 2017 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author  Dang Thanh Tung 
 * {@literal <dtt.dangthanhtung@gmail.com>}
 * @since   12/07/2017
 */
public class DateUtil {

	public static final String ddMMyyyy = "dd/MM/yyyy";
	public static final String ddMMyyyyHHmmss = "dd/MM/yyyy HH:mm:ss";
	public static final String HHmmssddMMyyyy = "HH:mm:ss dd/MM/yyyy";

	public static final String ddMMHHmm = "dd/MM HH:mm";
	public static final String HHmmddMM = "HH:mm dd/MM";

	public static final String DATE_TIME_MYSQL_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static String toDateString(Date date, String format) {
		if(date == null) return "";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static Date toDate(String dateString, String format) {
		if(StringUtil.isEmpty(dateString)) return null;
		DateFormat df = new SimpleDateFormat(format);
		Date date;
		try {
			date = df.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			date = null;
		}
		return date;
	}

	public static Date toBeginDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		CalendarUtil.toBeginDate(cal);
		return cal.getTime();
	}

	public static Date toEndDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		CalendarUtil.toEndDate(cal);
		return cal.getTime();
	}

}
