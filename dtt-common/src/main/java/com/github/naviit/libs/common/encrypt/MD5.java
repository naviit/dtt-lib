/************************************************
 * Copyright 2018 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.encrypt;

import java.security.MessageDigest;

public class MD5 {

  public static String hashData(String data) {
    try {
      MessageDigest hash = MessageDigest.getInstance("MD5");
      hash.update(data.getBytes());
      byte[] temp = hash.digest();
      return convertToHex(temp);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return "";
  }

  private static String convertToHex(byte[] data) {
    StringBuffer buf = new StringBuffer();

    for (int i = 0; i < data.length; i++) {
      int halfbyte = data[i] >>> 4 & 0xF;
      int two_halfs = 0;
      do {
        if ((0 <= halfbyte) && (halfbyte <= 9)) {
          buf.append((char) (48 + halfbyte));
        } else {
          buf.append((char) (97 + (halfbyte - 10)));
        }
        halfbyte = data[i] & 0xF;
      } while (two_halfs++ < 1);
    }
    return buf.toString();
  }

}
