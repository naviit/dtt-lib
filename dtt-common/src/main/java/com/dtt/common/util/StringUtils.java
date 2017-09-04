/************************************************************************
 * Copyright 2017 by DTT - All rights reserved.                         *    
 ************************************************************************/
package com.dtt.common.util;

/**
 * Author: Dang Thanh Tung
 * 		Email: dtt.dangthanhtung@gmail.com
 * Created: 14/07/2017
 */
public class StringUtils {

	public static boolean isEmpty(String...args) {
		for (String ele : args) {
			if(ele == null || ele.trim().isEmpty()) return true;
		}
		return false;
	}

	public static boolean isEmpty(String value) {
		return value == null || value.isEmpty();
	}

}
