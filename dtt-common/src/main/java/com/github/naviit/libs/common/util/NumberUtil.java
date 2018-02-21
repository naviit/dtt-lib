/************************************************
 * Copyright 2018 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.util;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author  Dang Thanh Tung 
 * {@literal <dtt.dangthanhtung@gmail.com>}
 * @since   08/11/2017
 */
public class NumberUtil {

  public static String formatCurrency(int price) {
    NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
    return formatter.format(price);
  }

}
