/************************************************
 * Copyright 2017 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.util;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author  Dang Thanh Tung 
 * {@literal <dtt.dangthanhtung@gmail.com>}
 * @since   28/12/2017
 */
public class NumberUtil {
  
  public static String formatCurrency(int price) {
    NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
    return formatter.format(price);
  }
  
}
