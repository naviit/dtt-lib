/************************************************************************
 * Copyright 2017 by DTT - All rights reserved.                         *    
 ************************************************************************/
package com.dtt.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Author: Dang Thanh Tung
 * 		Email: dtt.dangthanhtung@gmail.com
 * Created: 12/07/2017
 */
public class CalendarUtils {

	private static final String TIME_FORMAT = "HH:mm:ss";
	private static final SimpleDateFormat SDF = new SimpleDateFormat(TIME_FORMAT);
	
	/**
	 * Get current time
	 * @return time string with format HH:mm:ss
	 */
	public static String getCurrentTime() {
		return SDF.format(Calendar.getInstance().getTime());
	}
	
	public static Calendar toCalendar(String dateString, String format) {
		if(dateString == null || dateString.isEmpty()) return null;
		DateFormat df = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		try {
			Date date = df.parse(dateString);
			cal.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return cal;
	}
	
	public static void toBeginDate(Calendar cal) {
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
	}

	public static void toEndDate(Calendar cal) {
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
	}

}
