/************************************************
 * Copyright 2018 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.core.env.Environment;

/**
 * @author  Dang Thanh Tung 
 * {@literal <dtt.dangthanhtung@gmail.com>}
 * @since   12/02/2018
 */
public class EnvironmentUtil {

  private Environment env;

  private EnvironmentUtil(Environment env) {
    this.env = env;
  }

  public String getTextValue(String key, boolean required) {
    validKey(key);
    if(required) return env.getRequiredProperty(key);
    return env.getProperty(key);
  }

  public int getNumber(String key, int defaultValue) {
    validKey(key);
    String value = env.getProperty(key);
    if(StringUtil.isEmpty(value)) return defaultValue;

    try {
      return Integer.parseInt(value);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return defaultValue;
  }

  public List<Integer> getNumbers(String key, String separator) {
    validKey(key);
    String value = env.getProperty(key);
    if(StringUtil.isEmpty(value)) return new ArrayList<Integer>();

    String[] elements = value.split(separator);
    Function<String, Integer> numberParser = s -> {
      try {
        return Integer.parseInt(s);
      } catch (Exception e) {
        return -1;
      }
    };
    List<Integer> list = Arrays.stream(elements).map(numberParser).collect(Collectors.toList());
    list.removeIf(v -> v < 1);
    return list;
  }

  public long getLongNumber(String key, long defaultValue) {
    validKey(key);
    String value = env.getProperty(key);
    if(StringUtil.isEmpty(value)) return defaultValue;

    try {
      return Long.parseLong(value);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return defaultValue;
  }

  public List<Long> getLongNumbers(String key, String separator) {
    validKey(key);
    String value = env.getProperty(key);
    if(StringUtil.isEmpty(value)) return new ArrayList<Long>();

    String[] elements = value.split(separator);
    Function<String, Long> numberParser = s -> {
      try {
        return Long.parseLong(s);
      } catch (Exception e) {
        return (long) -1;
      }
    };
    List<Long> list = Arrays.stream(elements).map(numberParser).collect(Collectors.toList());
    list.removeIf(v -> v < 1);
    return list;
  }

  private boolean validKey(String key) {
    for(int i = 0; i < key.length(); i++) {
      char c = key.charAt(i);
      if(c == '_' || Character.isUpperCase(c)) {
        System.out.println("Invalid key name = "+ key + ". No uppercase - no underscore character");
        return false;
      }
    }
    return true;
  }

}
