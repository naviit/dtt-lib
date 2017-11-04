/************************************************************************
 * Copyright 2017 by DTT - All rights reserved.                         *    
 ************************************************************************/
package com.github.naviit.libs.common.exception;

/**
 * Author: Dang Thanh Tung
 * 		Email: dtt.dangthanhtung@gmail.com
 * Created: 11/07/2017
 */
public class ErrorCode {

	public static final int UNKNOWN_ERROR = 0;
	public static final String UNKNOWN_ERROR_DESC = "Lỗi không xác định";

	public static final int SUCCESS = 1;
	public static final String SUCCESS_DESC = "Thành công";

	public static final int INVALID_REQUEST = 2;
	public static final String INVALID_REQUEST_DESC = "Thông tin yêu cầu không hợp lệ";

	public static final int NOT_FOUND_ENTITY = 3;
	public static final String NOT_FOUND_ENTITY_DESC = "Không tìm thấy dữ liệu";

	public static final int DUPLICATED_ENTITY = 4;
	public static final String DUPLICATED_ENTITY_DESC = "Trùng lặp dữ liệu";

	public static final int INVALID_ENTITY = 5;
	public static final String INVALID_ENTITY_DESC = "Dữ liệu không hợp lệ";

	public static final int INVALID_FORMAT = 6;
	public static final String INVALID_FORMAT_DESC = "Định dạng không hợp lệ";

	public static final int INVALID_LENGTH = 7;
	public static final String INVALID_LENGTH_DESC = "Độ dài không hợp lệ";

	public static final int ERROR_WHEN_CREATE_ENTITY = 8;
	public static final String ERROR_WHEN_CREATE_ENTITY_DESC = "Khởi tạo lỗi";

	public static final int ERROR_WHEN_UPDATE_ENTITY = 9;
	public static final String ERROR_WHEN_UPDATE_ENTITY_DESC = "Cập nhật lỗi";

	public static final int ERROR_WHEN_MODIFY_ENTITY_FIELD = 10;
	public static final String ERROR_WHEN_MODIFY_ENTITY_FIELD_DESC = "Cập nhật lỗi";

	public static final int ERROR_WHEN_DELETE_ENTITY= 11;
	public static final String ERROR_WHEN_DELETE_ENTITY_DESC = "Xóa bị lỗi";

}
