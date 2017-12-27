/************************************************
 * Copyright 2017 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.model.response;

import java.io.Serializable;

import com.github.naviit.libs.common.util.JsonUtil;

/**
 * @author  Dang Thanh Tung 
 * {@literal <dtt.dangthanhtung@gmail.com>}
 * @since   13/09/2017
 */
@SuppressWarnings("serial")
public class RepositoryResponse<T> implements Serializable {

	protected int code;
	protected String message;
	protected T data;

	public RepositoryResponse() {}

	public RepositoryResponse(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public RepositoryResponse(int code, String message, T data) {
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
