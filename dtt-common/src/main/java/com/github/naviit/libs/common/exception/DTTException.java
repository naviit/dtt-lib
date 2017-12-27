/************************************************
 * Copyright 2017 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.exception;

import static com.github.naviit.libs.common.exception.ErrorCode.DUPLICATED_ENTITY;
import static com.github.naviit.libs.common.exception.ErrorCode.DUPLICATED_ENTITY_DESC;
import static com.github.naviit.libs.common.exception.ErrorCode.ERROR_WHEN_CREATE_ENTITY;
import static com.github.naviit.libs.common.exception.ErrorCode.ERROR_WHEN_CREATE_ENTITY_DESC;
import static com.github.naviit.libs.common.exception.ErrorCode.ERROR_WHEN_DELETE_ENTITY;
import static com.github.naviit.libs.common.exception.ErrorCode.ERROR_WHEN_DELETE_ENTITY_DESC;
import static com.github.naviit.libs.common.exception.ErrorCode.ERROR_WHEN_MODIFY_ENTITY_FIELD;
import static com.github.naviit.libs.common.exception.ErrorCode.ERROR_WHEN_MODIFY_ENTITY_FIELD_DESC;
import static com.github.naviit.libs.common.exception.ErrorCode.ERROR_WHEN_UPDATE_ENTITY;
import static com.github.naviit.libs.common.exception.ErrorCode.ERROR_WHEN_UPDATE_ENTITY_DESC;
import static com.github.naviit.libs.common.exception.ErrorCode.INVALID_ENTITY;
import static com.github.naviit.libs.common.exception.ErrorCode.INVALID_ENTITY_DESC;
import static com.github.naviit.libs.common.exception.ErrorCode.INVALID_FORMAT;
import static com.github.naviit.libs.common.exception.ErrorCode.INVALID_FORMAT_DESC;
import static com.github.naviit.libs.common.exception.ErrorCode.INVALID_LENGTH;
import static com.github.naviit.libs.common.exception.ErrorCode.INVALID_LENGTH_DESC;
import static com.github.naviit.libs.common.exception.ErrorCode.INVALID_REQUEST;
import static com.github.naviit.libs.common.exception.ErrorCode.INVALID_REQUEST_DESC;
import static com.github.naviit.libs.common.exception.ErrorCode.NOT_FOUND_ENTITY;
import static com.github.naviit.libs.common.exception.ErrorCode.NOT_FOUND_ENTITY_DESC;
import static com.github.naviit.libs.common.exception.ErrorCode.UNKNOWN_ERROR;
import static com.github.naviit.libs.common.exception.ErrorCode.UNKNOWN_ERROR_DESC;

/**
 * @author  Dang Thanh Tung 
 * {@literal <dtt.dangthanhtung@gmail.com>}
 * @since   05/09/2017
 */
public class DTTException extends Exception {

	private static final long serialVersionUID = 4274408760692076756L;

	private int errorCode;
	private Object data;

	public DTTException(int code) {
		this.errorCode = code;
	}

	public DTTException(int code, String message) {
		super(message);
		this.errorCode = code;
	}

	public DTTException(int code, String message, Object data) {
		super(data + ": " + message);
		this.errorCode = code;
		this.data = data;
	}

	public int getErrorCode() { return errorCode; }

	public Object getData() { return data; }

	public static class UnknowException extends DTTException {

		private static final long serialVersionUID = 7380060115304231242L;

		public UnknowException() {
			super(UNKNOWN_ERROR, UNKNOWN_ERROR_DESC);
		}

		public UnknowException(String message) {
			super(UNKNOWN_ERROR, message);
		}

		public UnknowException(Object data) {
			super(UNKNOWN_ERROR, UNKNOWN_ERROR_DESC, data);
		}

		public UnknowException(Object data, String message) {
			super(UNKNOWN_ERROR, message, data);
		}

	}

	public static class InvalidRequestException extends DTTException {

		private static final long serialVersionUID = -7459692391226129886L;

		public InvalidRequestException() {
			super(INVALID_REQUEST, INVALID_REQUEST_DESC);
		}

		public InvalidRequestException(String message) {
			super(INVALID_REQUEST, message);
		}

		public InvalidRequestException(Object data) {
			super(INVALID_REQUEST, INVALID_REQUEST_DESC, data);
		}

		public InvalidRequestException(Object data, String message) {
			super(INVALID_REQUEST, message, data);
		}

	}

	public static class NotFoundEntityException extends DTTException {

		private static final long serialVersionUID = -6143588956116625927L;

		public NotFoundEntityException() {
			super(NOT_FOUND_ENTITY, NOT_FOUND_ENTITY_DESC);
		}

		public NotFoundEntityException(String message) {
			super(NOT_FOUND_ENTITY, message);
		}

		public NotFoundEntityException(Object data) {
			super(NOT_FOUND_ENTITY, NOT_FOUND_ENTITY_DESC, data);
		}

		public NotFoundEntityException(Object data, String message) {
			super(NOT_FOUND_ENTITY, message, data);
		}

	}

	public static class DuplicatedEntityException extends DTTException {

		private static final long serialVersionUID = -8157631594355700808L;

		public DuplicatedEntityException() {
			super(DUPLICATED_ENTITY, DUPLICATED_ENTITY_DESC);
		}

		public DuplicatedEntityException(String message) {
			super(DUPLICATED_ENTITY, message);
		}

		public DuplicatedEntityException(Object data) {
			super(DUPLICATED_ENTITY, DUPLICATED_ENTITY_DESC, data);
		}

		public DuplicatedEntityException(Object data, String message) {
			super(DUPLICATED_ENTITY, message, data);
		}

	}

	public static class InvalidDataException extends DTTException {

		private static final long serialVersionUID = -8260869106253703510L;

		public InvalidDataException() {
			super(INVALID_ENTITY, INVALID_ENTITY_DESC);
		}

		public InvalidDataException(String message) {
			super(INVALID_ENTITY, message);
		}

		public InvalidDataException(Object data) {
			super(INVALID_ENTITY, INVALID_ENTITY_DESC, data);
		}

		public InvalidDataException(Object data, String message) {
			super(INVALID_ENTITY, message, data);
		}

	}

	public static class InvalidFormatException extends DTTException {

		private static final long serialVersionUID = 7026796137445277042L;

		public InvalidFormatException() {
			super(INVALID_FORMAT, INVALID_FORMAT_DESC);
		}

		public InvalidFormatException(String message) {
			super(INVALID_FORMAT, message);
		}

		public InvalidFormatException(Object data) {
			super(INVALID_FORMAT, INVALID_FORMAT_DESC, data);
		}

		public InvalidFormatException(Object data, String message) {
			super(INVALID_FORMAT, message, data);
		}

	}

	public static class InvalidLengthException extends DTTException {

		private static final long serialVersionUID = -8114344518979503052L;

		public InvalidLengthException() {
			super(INVALID_LENGTH, INVALID_LENGTH_DESC);
		}

		public InvalidLengthException(String message) {
			super(INVALID_LENGTH, message);
		}

		public InvalidLengthException(Object data) {
			super(INVALID_LENGTH, INVALID_LENGTH_DESC, data);
		}

		public InvalidLengthException(Object data, String message) {
			super(INVALID_LENGTH, message, data);
		}

	}

	public static class ErrorCreationException extends DTTException {

		private static final long serialVersionUID = 8588385436497619088L;

		public ErrorCreationException() {
			super(ERROR_WHEN_CREATE_ENTITY, ERROR_WHEN_CREATE_ENTITY_DESC);
		}

		public ErrorCreationException(String message) {
			super(ERROR_WHEN_CREATE_ENTITY, message);
		}

		public ErrorCreationException(Object data) {
			super(ERROR_WHEN_CREATE_ENTITY, ERROR_WHEN_CREATE_ENTITY_DESC, data);
		}

		public ErrorCreationException(Object data, String message) {
			super(ERROR_WHEN_CREATE_ENTITY, message, data);
		}

	}

	public static class ErrorUpdateException extends DTTException {

		private static final long serialVersionUID = 1043089496804826231L;

		public ErrorUpdateException() {
			super(ERROR_WHEN_UPDATE_ENTITY, ERROR_WHEN_UPDATE_ENTITY_DESC);
		}

		public ErrorUpdateException(String message) {
			super(ERROR_WHEN_UPDATE_ENTITY, message);
		}

		public ErrorUpdateException(Object data) {
			super(ERROR_WHEN_UPDATE_ENTITY, ERROR_WHEN_UPDATE_ENTITY_DESC, data);
		}

		public ErrorUpdateException(Object data, String message) {
			super(ERROR_WHEN_UPDATE_ENTITY, message, data);
		}

	}

	public static class ErrorModificationException extends DTTException {

		private static final long serialVersionUID = 5690696523821383243L;

		public ErrorModificationException() {
			super(ERROR_WHEN_MODIFY_ENTITY_FIELD, ERROR_WHEN_MODIFY_ENTITY_FIELD_DESC);
		}

		public ErrorModificationException(String message) {
			super(ERROR_WHEN_MODIFY_ENTITY_FIELD, message);
		}

		public ErrorModificationException(Object data) {
			super(ERROR_WHEN_MODIFY_ENTITY_FIELD, ERROR_WHEN_MODIFY_ENTITY_FIELD_DESC, data);
		}

		public ErrorModificationException(Object data, String message) {
			super(ERROR_WHEN_MODIFY_ENTITY_FIELD, message, data);
		}

	}

	public static class ErrorDeleteException extends DTTException {

		private static final long serialVersionUID = -3676318400628112602L;

		public ErrorDeleteException() {
			super(ERROR_WHEN_DELETE_ENTITY, ERROR_WHEN_DELETE_ENTITY_DESC);
		}

		public ErrorDeleteException(String message) {
			super(ERROR_WHEN_DELETE_ENTITY, message);
		}

		public ErrorDeleteException(Object data) {
			super(ERROR_WHEN_DELETE_ENTITY, ERROR_WHEN_DELETE_ENTITY_DESC, data);
		}

		public ErrorDeleteException(Object data, String message) {
			super(ERROR_WHEN_DELETE_ENTITY, message, data);
		}

	}

}
