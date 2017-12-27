/************************************************
 * Copyright 2017 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.util;

import java.text.DateFormat;
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

  public static final String DATE_MYSQL_FORMAT = "yyyy-MM-dd";
  public static final String DATE_TIME_MYSQL_FORMAT = "yyyy-MM-dd HH:mm:ss";

  public static String toDateString(Date date, String format) {
    try {
      if(date == null || StringUtil.isEmpty(format)) return null;
      SimpleDateFormat sdf = new SimpleDateFormat(format);
      return sdf.format(date);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public static String toDateString(long timeInMiliseconds, String format) {
    if(StringUtil.isEmpty(format)) return null;
    Date date = new Date(timeInMiliseconds);
    return toDateString(date, format);
  }

  public static Date toDate(String dateString, String format) {
    try {
      if(StringUtil.isEmpty(dateString) || StringUtil.isEmpty(format)) return null;
      DateFormat df = new SimpleDateFormat(format);
      return df.parse(dateString);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
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