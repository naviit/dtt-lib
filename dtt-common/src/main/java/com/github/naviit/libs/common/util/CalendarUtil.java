/************************************************************************
 * Copyright 2017 by DTT - All rights reserved.                         *    
 ************************************************************************/
package com.github.naviit.libs.common.util;

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
public class CalendarUtil {

	private static final String TIME_FORMAT = "HH:mm:ss";
	private static final SimpleDateFormat SDF = new SimpleDateFormat(TIME_FORMAT);

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

	/**
	 * Get current time with format HH:mm:ss
	 */
	public static String getCurrentTime() {
		return SDF.format(Calendar.getInstance().getTime());
	}

	public static long getCurrentDateInMillis() {
		Calendar cal = Calendar.getInstance();
		return cal.getTimeInMillis();
	}

	public static long getBeginOfCurrentDateInMillis() {
		Calendar cal = Calendar.getInstance();
		toBeginDate(cal);
		return cal.getTimeInMillis();
	}

	public static Calendar toCalendar(String dateString, String format) {
		if(StringUtil.isEmpty(dateString)) return null;
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
