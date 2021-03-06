/************************************************
 * Copyright 2017 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.validator;

import java.util.Date;

import com.github.naviit.libs.common.exception.DTTException;
import com.github.naviit.libs.common.util.DateUtil;
import com.github.naviit.libs.common.util.StringUtil;

/**
 * @author  Dang Thanh Tung 
 * {@literal <dtt.dangthanhtung@gmail.com>}
 * @since   28/12/2017
 */
public abstract class InputValidator extends FormatValidator {

  public void validateEmptyField(String value) throws DTTException {
    if (StringUtil.isEmpty(value)) throw new DTTException.NoDataException();
  }

  public void validateEmptyField(String value, String message) throws DTTException {
    if (StringUtil.isEmpty(value)) throw new DTTException.NoDataException(message);
  }

  public void validateEmptyField(Integer value) throws DTTException {
    if (value == null) throw new DTTException.NoDataException();
  }

  public void validateEmptyField(Integer value, String message) throws DTTException {
    if (value == null) throw new DTTException.NoDataException(message);
  }

  public void validateEmptyField(Long value) throws DTTException {
    if (value == null) throw new DTTException.NoDataException();
  }

  public void validateEmptyField(Long value, String message) throws DTTException {
    if (value == null) throw new DTTException.NoDataException(message);
  }

  public void validateEmptyField(Short value) throws DTTException {
    if (value == null) throw new DTTException.NoDataException();
  }

  public void validateEmptyField(Short value, String message) throws DTTException {
    if (value == null) throw new DTTException.NoDataException(message);
  }

  public void validateEmptyField(Double value) throws DTTException {
    if (value == null) throw new DTTException.NoDataException();
  }

  public void validateEmptyField(Double value, String message) throws DTTException {
    if (value == null) throw new DTTException.NoDataException(message);
  }

  public void validateEmptyField(Float value) throws DTTException {
    if (value == null) throw new DTTException.NoDataException();
  }

  public void validateEmptyField(Float value, String message) throws DTTException {
    if (value == null) throw new DTTException.NoDataException(message);
  }

  public void validateIntegerField(String value) throws DTTException {
    if(StringUtil.isEmpty(value)) throw new DTTException.NoDataException();
    char [] chars = value.toCharArray();
    for(char c : chars) {
      if(Character.isDigit(c) || c == '_' || c == ',') continue;
      throw new DTTException.InvalidFormatDataException();
    }
  }

  public void validateIntegerField(String value, String message) throws DTTException {
    if(StringUtil.isEmpty(value)) throw new DTTException.NoDataException(message);
    char [] chars = value.toCharArray();
    for(char c : chars) {
      if(Character.isDigit(c) || c == '_' || c == ',') continue;
      throw new DTTException.InvalidFormatDataException(message);
    }
  }

  public void validateFloatField(String value) throws DTTException {
    if(StringUtil.isEmpty(value)) throw new DTTException.NoDataException();
    char [] chars = value.toCharArray();
    for(char c : chars) {
      if(Character.isDigit(c) || c == '_' || c == ',' || c == '.') continue;
      throw new DTTException.InvalidFormatDataException();
    }
  }

  public void validateFloatField(String value, String message) throws DTTException {
    if(StringUtil.isEmpty(value)) throw new DTTException.NoDataException(message);
    char [] chars = value.toCharArray();
    for(char c : chars) {
      if(Character.isDigit(c) || c == '_' || c == ',' || c == '.') continue;
      throw new DTTException.InvalidFormatDataException(message);
    }
  }

  public Date validateDateTimeField(String value, String format) throws DTTException {
    if(StringUtil.isEmpty(value) || StringUtil.isEmpty(format)) throw new DTTException.NoDataException();
    Date date = DateUtil.toDate(value, format);
    if(date == null) throw new DTTException.InvalidFormatDataException();
    return date;
  }

  public Date validateDateTimeField(String value, String format, String message) throws DTTException {
    if (StringUtil.isEmpty(value) || StringUtil.isEmpty(format)) throw new DTTException.NoDataException(message);
    Date date = DateUtil.toDate(value, format);
    if(date == null) throw new DTTException.InvalidFormatDataException(message);
    return date;
  }

  public void validateRangeField(Long value, long min, long max) throws DTTException {
    if (value == null) throw new DTTException.NoDataException();
    long data = value.longValue();
    if(data < min || data > max) throw new DTTException.InvalidDataException();
  }

  public void validateRangeField(Long value, long min, long max, String message) throws DTTException {
    if (value == null) throw new DTTException.NoDataException(message);
    long data = value.longValue();
    if(data < min || data > max) throw new DTTException.InvalidDataException(message);
  }

  public void validateRangeField(Integer value, int min, int max) throws DTTException {
    if (value == null) throw new DTTException.NoDataException();
    int data = value.intValue();
    if(data < min || data > max) throw new DTTException.InvalidDataException();
  }

  public void validateRangeField(Integer value, int min, int max, String message) throws DTTException {
    if (value == null) throw new DTTException.NoDataException(message);
    int data = value.intValue();
    if(data < min || data > max) throw new DTTException.InvalidDataException(message);
  }

  public void validateRangeField(Short value, short min, short max) throws DTTException {
    if (value == null) throw new DTTException.NoDataException();
    short data = value.shortValue();
    if(data < min || data > max) throw new DTTException.InvalidDataException();
  }

  public void validateRangeField(Short value, short min, short max, String message) throws DTTException {
    if (value == null) throw new DTTException.NoDataException(message);
    short data = value.shortValue();
    if(data < min || data > max) throw new DTTException.InvalidDataException(message);
  }

  public void validateRangeField(Date value, Date min, Date max) throws DTTException {
    if (value == null) throw new DTTException.NoDataException();
    if(value.before(min) || value.after(max)) throw new DTTException.InvalidDataException();
  }

  public void validateRangeField(Date value, Date min, Date max, String message) throws DTTException {
    if (value == null) throw new DTTException.NoDataException(message);
    if(value.before(min) || value.after(max)) throw new DTTException.InvalidDataException(message);
  }

  public void validateRangeLengthField(String value, int minLength, int maxLength) throws DTTException {
    if(value.length() >= minLength && value.length() <= maxLength) return;
    throw new DTTException.InvalidDataException("Invalid Range Length (" + minLength + ", " + maxLength + ")");
  }

  public void validateRangeLengthField(String value, int minLength, int maxLength, String message) throws DTTException {
    if(value.length() >= minLength && value.length() <= maxLength) return;
    throw new DTTException.InvalidDataException(message);
  }

  public void validateMinField(Long value, long min) throws DTTException {
    if (value == null) throw new DTTException.NoDataException();
    long data = value.longValue();
    if(data < min) throw new DTTException.InvalidDataException();
  }

  public void validateMinField(Long value, long min, String message) throws DTTException {
    if (value == null) throw new DTTException.NoDataException(message);
    long data = value.longValue();
    if(data < min) throw new DTTException.InvalidDataException(message);
  }

  public void validateMinField(Integer value, int min) throws DTTException {
    if (value == null) throw new DTTException.NoDataException();
    int data = value.intValue();
    if(data < min) throw new DTTException.InvalidDataException();
  }

  public void validateMinField(Integer value, int min, String message) throws DTTException {
    if (value == null) throw new DTTException.NoDataException(message);
    int data = value.intValue();
    if(data < min) throw new DTTException.InvalidDataException(message);
  }

  public void validateMinField(Short value, short min) throws DTTException {
    if (value == null) throw new DTTException.NoDataException();
    short data = value.shortValue();
    if(data < min) throw new DTTException.InvalidDataException();
  }

  public void validateMinField(Short value, short min, String message) throws DTTException {
    if(value == null) throw new DTTException.NoDataException(message);
    short data = value.shortValue();
    if(data < min) throw new DTTException.InvalidDataException(message);
  }

  public void validateMinField(Date value, Date min) throws DTTException {
    if (value == null) throw new DTTException.NoDataException();
    if(min.after(value)) throw new DTTException.InvalidDataException();
  }

  public void validateMinField(Date value, Date min, String message) throws DTTException {
    if (value == null) throw new DTTException.NoDataException(message);
    if(min.after(value)) throw new DTTException.InvalidDataException(message);
  }

  public void validateMinLengthField(String value, int minLength) throws DTTException {
    if(value.length() >= minLength) return;
    throw new DTTException.InvalidDataException("Invalid Min Length (" + minLength + ")");
  }

  public void validateMinLengthField(String value, int minLength, String message) throws DTTException {
    if(value.length() >= minLength) return;
    throw new DTTException.InvalidDataException(message);
  }

  public void validateMaxField(Long value, long max) throws DTTException {
    if (value == null) throw new DTTException.NoDataException();
    long data = value.longValue();
    if(data > max) throw new DTTException.InvalidDataException();
  }

  public void validateMaxField(Long value, long max, String message) throws DTTException {
    if (value == null) throw new DTTException.NoDataException(message);
    long data = value.longValue();
    if(data > max) throw new DTTException.InvalidDataException(message);
  }

  public void validateMaxField(Integer value, int max) throws DTTException {
    if (value == null) throw new DTTException.NoDataException();
    int data = value.intValue();
    if(data > max) throw new DTTException.InvalidDataException();
  }

  public void validateMaxField(Integer value, int max, String message) throws DTTException {
    if (value == null) throw new DTTException.NoDataException(message);
    int data = value.intValue();
    if(data > max) throw new DTTException.InvalidDataException(message);
  }

  public void validateMaxField(Short value, short max) throws DTTException {
    if (value == null) throw new DTTException.NoDataException();
    short data = value.shortValue();
    if(data > max) throw new DTTException.InvalidDataException();
  }

  public void validateMaxField(Short value, short max, String message) throws DTTException {
    if (value == null) throw new DTTException.NoDataException(message);
    short data = value.shortValue();
    if(data > max) throw new DTTException.InvalidDataException(message);
  }

  public void validateMaxField(Date value, Date max) throws DTTException {
    if (value == null) throw new DTTException.NoDataException();
    if(value.after(max)) throw new DTTException.InvalidDataException();
  }

  public void validateMaxField(Date value, Date max, String message) throws DTTException {
    if (value == null) throw new DTTException.NoDataException(message);
    if(value.after(max)) throw new DTTException.InvalidDataException(message);
  }

  public void validateMaxLengthField(String value, int maxLength) throws DTTException {
    if(value.length() <= maxLength) return;
    throw new DTTException.InvalidDataException("Invalid Max Length (" + maxLength + ")");
  }

  public void validateMaxLengthField(String value, int maxLength, String message) throws DTTException {
    if(value.length() <= maxLength) return;
    throw new DTTException.InvalidDataException(message);
  }

  public void validateSomeValuesField(Long value, long...values) throws DTTException {
    if (value == null) throw new DTTException.NoDataException();
    long temp = value.longValue();
    for(long ele : values) {
      if(temp == ele) return;
    }
    throw new DTTException.InvalidDataException();
  }

  public void validateSomeValuesField(Long value, String message, long...values) throws DTTException {
    if (value == null) throw new DTTException.NoDataException(message);
    long temp = value.longValue();
    for(long ele : values) {
      if(temp == ele) return;
    }
    throw new DTTException.InvalidDataException(message);
  }

  public void validateSomeValuesField(Integer value, int...values) throws DTTException {
    if (value == null) throw new DTTException.NoDataException();
    int temp = value.intValue();
    for(int ele : values) {
      if(ele == temp) return;
    }
    throw new DTTException.InvalidDataException();
  }

  public void validateSomeValuesField(Integer value, String message, int...values) throws DTTException {
    if (value == null) throw new DTTException.NoDataException(message);
    int temp = value.intValue();
    for(int ele : values) {
      if(ele == temp) return;
    }
    throw new DTTException.InvalidDataException(message);
  }

  public void validateSomeValuesField(Short value, short...values) throws DTTException {
    if (value == null) throw new DTTException.NoDataException();
    short temp = value.shortValue();
    for(short ele : values) {
      if(ele == temp) return;
    }
    throw new DTTException.InvalidDataException();
  }

  public void validateSomeValuesField(Short value, String message, short...values) throws DTTException {
    if (value == null) throw new DTTException.NoDataException(message);
    short temp = value.shortValue();
    for(short ele : values) {
      if(ele == temp) return;
    }
    throw new DTTException.InvalidDataException(message);
  }

  public void validateSomeValuesField(String value, String...values) throws DTTException {
    if (StringUtil.isEmpty(value)) throw new DTTException.NoDataException();
    for(String ele : values) {
      if(value.equals(ele)) return;
    }
    throw new DTTException.InvalidDataException();
  }

  public void validateSomeValuesField(String value, String message, String...values) throws DTTException {
    if (StringUtil.isEmpty(value)) throw new DTTException.NoDataException(message);
    for(String ele : values) {
      if(value.equals(ele)) return;
    }
    throw new DTTException.InvalidDataException(message);
  }

  public void validateSomeValuesField(Character value, char...values) throws DTTException {
    if(value == null) throw new DTTException.NoDataException();
    char temp = value.charValue();
    for(char ele : values) {
      if(ele == temp) return;
    }
    throw new DTTException.InvalidDataException();
  }

  public void validateSomeValuesField(Character value, String message, char...values) throws DTTException {
    if(value == null) throw new DTTException.NoDataException(message);
    char temp = value.charValue();
    for(char ele : values) {
      if(ele == temp) return;
    }
    throw new DTTException.InvalidDataException(message);
  }

}
