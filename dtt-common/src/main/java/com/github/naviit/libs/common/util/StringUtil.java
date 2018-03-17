/************************************************
 * Copyright 2018 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.util;

import java.util.Iterator;
import java.util.List;

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
  public static final String COLON = ":";
  public static final String SEMICOLON = ";";
  public static final String UNDERSCORE = "_";

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

  public static String concatenate(List<String> listOfItems, String separator) {
    StringBuilder sb = new StringBuilder();
    Iterator<String> iterator = listOfItems.iterator();
    while (iterator.hasNext()) {
      sb.append(iterator.next());
      if (iterator.hasNext()) {
        sb.append(separator);
      }
    }
    return sb.toString();
  }

  public static String toStringFromList(List<String> list, String separator) {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < list.size(); i++) {
      sb.append(list.get(i));
      if(i < (list.size() -1)) {
        sb.append(separator); 
      }
    } 
    return sb.toString();
  }

}
