/************************************************
 * Copyright 2017 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author  Dang Thanh Tung 
 * {@literal <dtt.dangthanhtung@gmail.com>}
 * @since   12/07/2017
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
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(timeInMiliseconds);
    return calendar.get(Calendar.DAY_OF_WEEK);
  }

  public static String getLastDayOfMonth(String format) {
    Date today = new Date();  

    Calendar calendar = Calendar.getInstance();  
    calendar.setTime(today);  

    calendar.add(Calendar.MONTH, 1);  
    calendar.set(Calendar.DAY_OF_MONTH, 1);  
    calendar.add(Calendar.DATE, -1);  

    Long lastDayOfMonth = calendar.getTimeInMillis();
    return DateUtil.toDateString(lastDayOfMonth, format);
  }

}