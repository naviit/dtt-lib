/************************************************
 * Copyright 2018 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.util;

/**
 * @author  Dang Thanh Tung 
 * {@literal <dtt.dangthanhtung@gmail.com>}
 * @since   08/11/2017
 */
public class StringUtil {

  public static final String EMPTY = "";
  public static final String SPACE = " ";
  public static final String DOT = ".";
  public static final String COMMA = ",";

  public static boolean isEmpty(String... args) {
    for (String ele : args) {
      if (ele == null || ele.trim().isEmpty())
        return true;
    }
    return false;
  }

  public static boolean isEmpty(String value) {
    return value == null || value.isEmpty();
  }

}
