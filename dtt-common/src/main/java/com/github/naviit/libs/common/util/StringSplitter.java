/************************************************
 * Copyright 2017 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  Dang Thanh Tung 
 * {@literal <dtt.dangthanhtung@gmail.com>}
 * @since   28/12/2017
 */
public class StringSplitter {

  public static List<String> toListBySpace(String value) {
    if (value == null) return new ArrayList<String>(0);
    List<String> temp = new ArrayList<String>((value.length() / 2) + 1);
    int start = 0;
    int i = 1;
    while (i < value.length()) {
      char c = value.charAt(i);
      if (Character.isWhitespace(c) || Character.isSpaceChar(c)) {
        String element = value.substring(start, i);
        if (!element.isEmpty()) temp.add(element);
        start = i + 1;
        i++;
        continue;
      }
      i++;
    }
    if (start < value.length()) {
      String element = value.substring(start);
      if (!element.isEmpty()) temp.add(element);
    }
    return temp;
  }

  public static String[] toArrayBySpace(String value){  
    List<String> list = toListBySpace(value);
    return list.toArray(new String[list.size()]);
  }

  public static void main(String[] args) {
    List<String> test = toListBySpace("Tung is hand Some");
    System.out.println(test);
  }

}
