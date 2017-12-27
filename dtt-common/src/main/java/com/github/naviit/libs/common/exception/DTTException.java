/************************************************
 * Copyright 2017 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.exception;

import static com.github.naviit.libs.common.exception.ErrorCode.DUPLICATED_DATA;
import static com.github.naviit.libs.common.exception.ErrorCode.DUPLICATED_DATA_DESC;
import static com.github.naviit.libs.common.exception.ErrorCode.ERROR_WHEN_CREATE_DATA;
import static com.github.naviit.libs.common.exception.ErrorCode.ERROR_WHEN_CREATE_DATA_DESC;
import static com.github.naviit.libs.common.exception.ErrorCode.ERROR_WHEN_DELETE_DATA;
import static com.github.naviit.libs.common.exception.ErrorCode.ERROR_WHEN_DELETE_DATA_DESC;
import static com.github.naviit.libs.common.exception.ErrorCode.ERROR_WHEN_UPDATE_DATA;
import static com.github.naviit.libs.common.exception.ErrorCode.ERROR_WHEN_UPDATE_DATA_DESC;
import static com.github.naviit.libs.common.exception.ErrorCode.EXPIRED_DATA;
import static com.github.naviit.libs.common.exception.ErrorCode.EXPIRED_DATA_DESC;
import static com.github.naviit.libs.common.exception.ErrorCode.INVALID_DATA;
import static com.github.naviit.libs.common.exception.ErrorCode.INVALID_DATA_DESC;
import static com.github.naviit.libs.common.exception.ErrorCode.INVALID_FORMAT_DATA;
import static com.github.naviit.libs.common.exception.ErrorCode.INVALID_FORMAT_DATA_DESC;
import static com.github.naviit.libs.common.exception.ErrorCode.NOT_FOUND_DATA;
import static com.github.naviit.libs.common.exception.ErrorCode.NOT_FOUND_DATA_DESC;
import static com.github.naviit.libs.common.exception.ErrorCode.NOT_MATCH_DATA;
import static com.github.naviit.libs.common.exception.ErrorCode.NOT_MATCH_DATA_DESC;
import static com.github.naviit.libs.common.exception.ErrorCode.NO_DATA;
import static com.github.naviit.libs.common.exception.ErrorCode.NO_DATA_DESC;
import static com.github.naviit.libs.common.exception.ErrorCode.UNKNOWN_ERROR;
import static com.github.naviit.libs.common.exception.ErrorCode.UNKNOWN_ERROR_DESC;

/**
 * @author  Dang Thanh Tung 
 * {@literal <dtt.dangthanhtung@gmail.com>}
 * @since   05/09/2017
 */
public class DTTException extends Exception {

  private static final long serialVersionUID = 4274408760692076756L;

  private int code;

  public DTTException(int code) {
    this.code = code;
  }

  public DTTException(int code, String message) {
    super(message);
    this.code = code;
  }

  public int getCode() { return code; }

  public static class UnknowException extends DTTException {

    private static final long serialVersionUID = 7380060115304231242L;

    public UnknowException() {
      super(UNKNOWN_ERROR, UNKNOWN_ERROR_DESC);
    }

  }

  public static class NotFoundDataException extends DTTException {

    private static final long serialVersionUID = -6143588956116625927L;

    public NotFoundDataException() {
      super(NOT_FOUND_DATA, NOT_FOUND_DATA_DESC);
    }

    public NotFoundDataException(String message) {
      super(NOT_FOUND_DATA, message);
    }

  }

  public static class DuplicatedDataException extends DTTException {

    private static final long serialVersionUID = -8157631594355700808L;

    public DuplicatedDataException() {
      super(DUPLICATED_DATA, DUPLICATED_DATA_DESC);
    }

    public DuplicatedDataException(String message) {
      super(DUPLICATED_DATA, message);
    }

  }

  public static class ErrorCreateDataException extends DTTException {

    private static final long serialVersionUID = 8588385436497619088L;

    public ErrorCreateDataException() {
      super(ERROR_WHEN_CREATE_DATA, ERROR_WHEN_CREATE_DATA_DESC);
    }

    public ErrorCreateDataException(String message) {
      super(ERROR_WHEN_CREATE_DATA, message);
    }

  }

  public static class ErrorUpdateDataException extends DTTException {

    private static final long serialVersionUID = 1043089496804826231L;

    public ErrorUpdateDataException() {
      super(ERROR_WHEN_UPDATE_DATA, ERROR_WHEN_UPDATE_DATA_DESC);
    }

    public ErrorUpdateDataException(String message) {
      super(ERROR_WHEN_UPDATE_DATA, message);
    }

  }

  public static class ErrorDeleteDataException extends DTTException {

    private static final long serialVersionUID = -3676318400628112602L;

    public ErrorDeleteDataException() {
      super(ERROR_WHEN_DELETE_DATA, ERROR_WHEN_DELETE_DATA_DESC);
    }

    public ErrorDeleteDataException(String message) {
      super(ERROR_WHEN_DELETE_DATA, message);
    }

  }

  public static class NoDataException extends DTTException {

    private static final long serialVersionUID = -384483326556174188L;

    public NoDataException() {
      super(NO_DATA, NO_DATA_DESC);
    }

    public NoDataException(String message) {
      super(NO_DATA, message);
    }

  }

  public static class InvalidDataException extends DTTException {

    private static final long serialVersionUID = 3548366276454776739L;

    public InvalidDataException() {
      super(INVALID_DATA, INVALID_DATA_DESC);
    }

    public InvalidDataException(String message) {
      super(INVALID_DATA, message);
    }

  }

  public static class InvalidFormatDataException extends DTTException {

    private static final long serialVersionUID = -6894658813607627859L;

    public InvalidFormatDataException() {
      super(INVALID_FORMAT_DATA, INVALID_FORMAT_DATA_DESC);
    }

    public InvalidFormatDataException(String message) {
      super(INVALID_FORMAT_DATA, message);
    }

  }

  public static class NotMatchDataException extends DTTException {

    private static final long serialVersionUID = -2203711591734114431L;

    public NotMatchDataException() {
      super(NOT_MATCH_DATA, NOT_MATCH_DATA_DESC);
    }

    public NotMatchDataException(String message) {
      super(NOT_MATCH_DATA, message);
    }

  }

  public static class ExpiredDataException extends DTTException {

    private static final long serialVersionUID = -3436143130378185928L;

    public ExpiredDataException() {
      super(EXPIRED_DATA, EXPIRED_DATA_DESC);
    }

    public ExpiredDataException(String message) {
      super(EXPIRED_DATA, message);
    }

  }

}
