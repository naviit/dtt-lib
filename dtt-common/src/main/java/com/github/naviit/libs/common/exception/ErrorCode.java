/************************************************
 * Copyright 2017 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.exception;

/**
 * @author  Dang Thanh Tung 
 * {@literal <dtt.dangthanhtung@gmail.com>}
 * @since   11/07/2017
 */
public class ErrorCode {

  public static final int UNKNOWN_ERROR = 0;
  public static final String UNKNOWN_ERROR_DESC = "Lỗi không xác định";

  public static final int SUCCESS = 1;
  public static final String SUCCESS_DESC = "Thành công";

  public static final int NOT_FOUND_DATA = 2;
  public static final String NOT_FOUND_DATA_DESC = "Không tìm thấy dữ liệu";

  public static final int DUPLICATED_DATA = 3;
  public static final String DUPLICATED_DATA_DESC = "Trùng lặp dữ liệu";

  public static final int ERROR_WHEN_CREATE_DATA = 4;
  public static final String ERROR_WHEN_CREATE_DATA_DESC = "Khởi tạo dữ liệu bị lỗi";

  public static final int ERROR_WHEN_UPDATE_DATA = 5;
  public static final String ERROR_WHEN_UPDATE_DATA_DESC = "Cập nhật dữ liệu bị lỗi";

  public static final int ERROR_WHEN_DELETE_DATA= 6;
  public static final String ERROR_WHEN_DELETE_DATA_DESC = "Xóa dữ liệu bị lỗi";

  public static final int NO_DATA = 7;
  public static final String NO_DATA_DESC = "Dữ liệu bị null hoặc trống";

  public static final int INVALID_DATA = 8;
  public static final String INVALID_DATA_DESC = "Dữ liệu không hợp lệ";

  public static final int INVALID_FORMAT_DATA = 9;
  public static final String INVALID_FORMAT_DATA_DESC = "Dữ liệu không đúng định dạng";

  public static final int NOT_MATCH_DATA = 10;
  public static final String NOT_MATCH_DATA_DESC = "Dữ liệu không khớp";

  public static final int EXPIRED_DATA = 11;
  public static final String EXPIRED_DATA_DESC = "Dữ liệu đã bị hết hạn";

}
