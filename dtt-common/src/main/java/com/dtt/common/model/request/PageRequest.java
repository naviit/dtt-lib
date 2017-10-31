/************************************************************************
 * Copyright 2017 by DTT - All rights reserved.                         *    
 ************************************************************************/
package com.dtt.common.model.request;

import com.dtt.common.util.JsonUtils;

/**
 * Author: Dang Thanh Tung
 * 		Email: dtt.dangthanhtung@gmail.com
 * Created: 13/09/2017
 */
public class PageRequest {

	private String keyword;
	private String fromDate;
	private String toDate;

	private int pageNumber;
	private int pageSize;

	public PageRequest() {}

	public String getKeyword() { return keyword; }
	public void setKeyword(String keyword) { this.keyword = keyword; }

	public String getFromDate() { return fromDate; }
	public void setFromDate(String fromDate) { this.fromDate = fromDate; }

	public String getToDate() { return toDate; }
	public void setToDate(String toDate) { this.toDate = toDate; }

	public int getPageNumber() { return pageNumber; }
	public void setPageNumber(int pageNumber) { this.pageNumber = pageNumber; }

	public int getPageSize() { return pageSize; }
	public void setPageSize(int pageSize) { this.pageSize = pageSize; }

	@Override
	public String toString() {
		return JsonUtils.toJson(this);
	}

}
