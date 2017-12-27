/************************************************
 * Copyright 2017 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.model;

import java.io.Serializable;

import com.github.naviit.libs.common.util.JsonUtil;

/**
 * @author  Dang Thanh Tung 
 * {@literal <dtt.dangthanhtung@gmail.com>}
 * @since   28/12/2017
 */
public class DTTResponse<T> implements Serializable {

  private static final long serialVersionUID = 2282925303635918496L;

  protected int code;
  protected String message;
  protected T data;

  public DTTResponse() {}

  public DTTResponse(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public DTTResponse(int code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public int getCode() { return code; }
  public void setCode(int code) { this.code = code; }

  public String getMessage() { return message; }
  public void setMessage(String message) { this.message = message; }

  public T getData() { return data; }
  public void setData(T data) { this.data = data; }

  @Override
  public String toString() {
    return JsonUtil.toJson(this);
  }

}