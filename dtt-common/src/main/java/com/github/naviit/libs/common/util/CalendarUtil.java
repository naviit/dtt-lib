/************************************************
 * Copyright 2018 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.github.naviit.libs.common.DateTimeConstant;

/**
 * @author  Dang Thanh Tung 
 * {@literal <dtt.dangthanhtung@gmail.com>}
 * @since   12/07/2017
 */
public class CalendarUtil {

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

  public static Calendar toCalendar(String dateString, String format) {
    try {
      if(StringUtil.isEmpty(dateString) || StringUtil.isEmpty(format)) return null;
      DateFormat df = new SimpleDateFormat(format);
      Date date = df.parse(dateString);

      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      return cal;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public static String getCurrentTime() {
    SimpleDateFormat sdf = new SimpleDateFormat(DateTimeConstant.HHmmss);
    return sdf.format(Calendar.getInstance().getTime());
  }

  public static long getCurrentTimeInMillis() {
    Calendar cal = Calendar.getInstance();
    return cal.getTimeInMillis();
  }

  public static long getBeginOfCurrentTimeInMillis() {
    Calendar cal = Calendar.getInstance();
    toBeginDate(cal);
    return cal.getTimeInMillis();
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

  public static int getDayOfWeek(long timeInMiliseconds) {
    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(timeInMiliseconds);
    return cal.get(Calendar.DAY_OF_WEEK);
  }

  public static String getLastDayOfMonth(String format) {
    Date today = new Date();  

    Calendar cal = Calendar.getInstance();  
    cal.setTime(today);  

    cal.add(Calendar.MONTH, 1);  
    cal.set(Calendar.DAY_OF_MONTH, 1);  
    cal.add(Calendar.DATE, -1);  

    Long lastDayOfMonth = cal.getTimeInMillis();
    return DateUtil.toDateString(lastDayOfMonth, format);
  }

}
