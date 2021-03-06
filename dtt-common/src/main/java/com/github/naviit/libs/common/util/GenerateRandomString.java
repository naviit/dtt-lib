/************************************************
 * Copyright 2018 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import com.github.naviit.libs.common.DateTimeConstant;

public class GenerateRandomString {

  private static final char[] VALUES = {'a','b','c','d','e','f','g','h','i','j',
      'k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
      'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T',
      'U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};

  private static Random random = new Random(Calendar.getInstance().getTimeInMillis());

  public GenerateRandomString() {
    super();
  }

  public static StringBuilder generateRandomString(int length) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < length; i++) {
      int idx = random.nextInt(VALUES.length);
      builder.append(VALUES[idx]);
    }
    return builder;
  }

  public static String generateAvatarFileName() {
    SimpleDateFormat sdf = new SimpleDateFormat(DateTimeConstant.yyyyMMddHHmmss);
    return generateRandomString(5).append(sdf.format(Calendar.getInstance().getTime())).toString();
  }

}
