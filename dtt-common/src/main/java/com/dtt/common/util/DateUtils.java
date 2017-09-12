/************************************************************************
 * Copyright 2017 by DTT - All rights reserved.                         *    
 ************************************************************************/
package com.dtt.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Author: Dang Thanh Tung
 * 		Email: dtt.dangthanhtung@gmail.com
 * Created: 12/07/2017
 */
public class DateUtils {

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
		if(dateString == null || dateString.isEmpty()) return null;
		DateFormat df = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = df.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return date;
	}

	public static Date toBeginDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		CalendarUtils.toBeginDate(cal);
		date = cal.getTime();
		return date;
	}

	public static Date toEndDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		CalendarUtils.toEndDate(cal);
		date = cal.getTime();
		return date;
	}
	
	public static Date getDateNearCurrentMost(List<Date> dates) {
		final long now = Calendar.getInstance().getTimeInMillis();

		// Get date closest to "now"
		Date closest = Collections.min(dates, new Comparator<Date>() {

			@Override
			public int compare(Date d1, Date d2) {
				long diff1 = Math.abs(d1.getTime() - now);
				long diff2 = Math.abs(d2.getTime() - now);
				return Long.compare(diff1, diff2);
			}

		});

		return closest;
	}

	public static long getDateInMillisecondsNearCurrentMost(List<Long> dates) {
		final long now = Calendar.getInstance().getTimeInMillis();

		// Get date closest to "now"
		Long closest = Collections.min(dates, new Comparator<Long>() {

			@Override
			public int compare(Long d1, Long d2) {
				long diff1 = Math.abs(d1.longValue() - now);
				long diff2 = Math.abs(d2.longValue() - now);
				return Long.compare(diff1, diff2);
			}

		});

		return closest.longValue();
	}
	
}
