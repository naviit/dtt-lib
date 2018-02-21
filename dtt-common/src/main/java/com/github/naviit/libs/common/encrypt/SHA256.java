/************************************************
 * Copyright 2018 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.encrypt;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class SHA256 {

  public static String hmacSHA256WithSecret(String key, String data) throws Exception {
    Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
    SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
    sha256_HMAC.init(secret_key);
    return Base64.encodeToString(sha256_HMAC.doFinal(data.getBytes("UTF-8")), Base64.DEFAULT).trim();
  }

}
