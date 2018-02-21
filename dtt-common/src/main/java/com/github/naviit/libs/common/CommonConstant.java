/************************************************
 * Copyright 2018 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common;

import java.util.regex.Pattern;

/**
 * @author  Dang Thanh Tung 
 * {@literal <dtt.dangthanhtung@gmail.com>}
 * @since   21/02/2018
 */
public class CommonConstant {

  public static final int DEFAULT_PAGE_NUMBER = 1;
  public static final int DEFAULT_PAGE_SIZE = 10;

  public static final Pattern EMAIL_PATTERN = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
      + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

  public static final String PHONE_PATTERN = 
      "(\\+[0-9]+[\\- \\.]*)?"        // +<digits><sdd>*
      + "(\\([0-9]+\\)[\\- \\.]*)?"   // (<digits>)<sdd>*
      + "([0-9][0-9\\- \\.]+[0-9])"; // <digit><digit|sdd>+<digit>

}
