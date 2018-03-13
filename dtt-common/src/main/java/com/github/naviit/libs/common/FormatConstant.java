/************************************************
 * Copyright 2018 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common;

import java.util.regex.Pattern;

/**
 * @author  Dang Thanh Tung 
 * {@literal <dtt.dangthanhtung@gmail.com>}
 * @since   13/03/2018
 */
public class FormatConstant {

  public static final Pattern EMAIL_PATTERN = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
      + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

  public static final String PHONE_PATTERN = 
      "(\\+[0-9]+[\\- \\.]*)?"        // +<digits><sdd>*
      + "(\\([0-9]+\\)[\\- \\.]*)?"   // (<digits>)<sdd>*
      + "([0-9][0-9\\- \\.]+[0-9])"; // <digit><digit|sdd>+<digit>

  public static final Pattern UUID_PATTERN = Pattern.compile("^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-"
      + "[89ab][0-9a-f]{3}-[0-9a-f]{12}$");

  public static final Pattern OTP_PATTERN = Pattern.compile("\\d{6}");

}
