/************************************************
 * Copyright 2018 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author  Dang Thanh Tung 
 * {@literal <dtt.dangthanhtung@gmail.com>}
 * @since   12/07/2017
 */
public class DateUtil {

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

}
