/************************************************
 * Copyright 2018 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.validator;

import java.util.regex.Matcher;

import com.github.naviit.libs.common.FormatConstant;
import com.github.naviit.libs.common.exception.DTTException;
import com.github.naviit.libs.common.util.StringUtil;

/**
 * @author  Dang Thanh Tung 
 * {@literal <dtt.dangthanhtung@gmail.com>}
 * @since   13/03/2018
 */
public abstract class FormatValidator {

  public void validateEmailField(String value) throws DTTException {
    if (StringUtil.isEmpty(value)) throw new DTTException.NoDataException();
    Matcher matcher = FormatConstant.EMAIL_PATTERN.matcher(value.trim());
    if(matcher.matches()) return;
    throw new DTTException.InvalidFormatDataException();
  }

  public void validateEmailField(String value, String message) throws DTTException {
    if (StringUtil.isEmpty(value)) throw new DTTException.NoDataException(message);
    Matcher matcher = FormatConstant.EMAIL_PATTERN.matcher(value.trim());
    if(matcher.matches()) return;
    throw new DTTException.InvalidFormatDataException(message);
  }

  public String validatePhoneField(String value) throws DTTException {
    if (StringUtil.isEmpty(value)) throw new DTTException.NoDataException();
    String phone = PhoneValidator.validPhoneNumber(value);
    if(phone == null) throw new DTTException.InvalidFormatDataException();
    return phone;
  }

  public String validatePhoneField(String value, String message) throws DTTException {
    if (StringUtil.isEmpty(value)) throw new DTTException.NoDataException(message);
    String phone = PhoneValidator.validPhoneNumber(value);
    if(phone == null) throw new DTTException.InvalidFormatDataException(message);
    return phone;
  }

  public void validateUUIDField(String value) throws DTTException {
    if (StringUtil.isEmpty(value)) throw new DTTException.NoDataException();
    Matcher matcher = FormatConstant.UUID_PATTERN.matcher(value.trim());
    if(matcher.matches()) return;
    throw new DTTException.InvalidFormatDataException();
  }

  public void validateUUIDField(String value, String message) throws DTTException {
    if (StringUtil.isEmpty(value)) throw new DTTException.NoDataException(message);
    Matcher matcher = FormatConstant.UUID_PATTERN.matcher(value.trim());
    if(matcher.matches()) return;
    throw new DTTException.InvalidFormatDataException(message);
  }

  public void validateOTPField(String value) throws DTTException {
    if (StringUtil.isEmpty(value)) throw new DTTException.NoDataException();
    Matcher matcher = FormatConstant.OTP_PATTERN.matcher(value.trim());
    if(matcher.matches()) return;
    throw new DTTException.InvalidFormatDataException();
  }

  public void validateOTPField(String value, String message) throws DTTException {
    if (StringUtil.isEmpty(value)) throw new DTTException.NoDataException(message);
    Matcher matcher = FormatConstant.OTP_PATTERN.matcher(value.trim());
    if(matcher.matches()) return;
    throw new DTTException.InvalidFormatDataException(message);
  }

}
