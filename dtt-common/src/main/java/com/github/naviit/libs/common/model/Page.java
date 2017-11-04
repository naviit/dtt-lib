/************************************************************************
 * Copyright 2017 by DTT - All rights reserved.                         *    
 ************************************************************************/
package com.github.naviit.libs.common.model;

import java.util.ArrayList;
import java.util.List;

import com.github.naviit.libs.common.util.DTTConstant;
import com.github.naviit.libs.common.util.JsonUtil;

/**
 * Author: Dang Thanh Tung
 * 		Email: dtt.dangthanhtung@gmail.com
 * Created: 09/07/2017
 */
public class Page<E> {

	private int pageNumber;
	private int pageSize;
	public List<E> pageItems;

	private long totalItems;
	private int pagesAvailable;

	private long time;

	public Page() {
		this.pageItems = new ArrayList<E>(DTTConstant.DEFAULT_PAGE_SIZE);
	}

	public Page(int pageNumber, int pageSize) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.pageItems = new ArrayList<E>(pageSize);
	}

	public Page(int pageNumber, int pageSize, long totalItems) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.pageItems = new ArrayList<E>(pageSize);

		this.totalItems = totalItems;
		this.computePagesAvailable(totalItems, pageSize);
	}

	public int getPageNumber() { return pageNumber; }
	public void setPageNumber(int pageNumber) { this.pageNumber = pageNumber; }

	public int getPageSize() { return pageSize; }
	public void setPageSize(int pageSize) { this.pageSize = pageSize; }

	public int getPagesAvailable() { return pagesAvailable; }
	public void setPagesAvailable(int pagesAvailable) { this.pagesAvailable = pagesAvailable; }

	public long getTotalItems() { return totalItems; }
	public void setTotalItems(long totalItems) { this.totalItems = totalItems; }

	public long getTime() { return time; }
	public void setTime(long time) { this.time = time; }

	public List<E> getPageItems() { return pageItems; }
	public void setPageItems(List<E> pageItems) { this.pageItems = pageItems; }

	public void computePagesAvailable(long totalItems, int pageSize) {
		this.pagesAvailable = 0;
		if(totalItems % pageSize == 0) {
			this.pagesAvailable = (int) (totalItems / pageSize);
		} else {
			this.pagesAvailable = (int) (totalItems / pageSize) + 1;
		}
	}

	@Override
	public String toString() {
		return JsonUtil.toJson(this);
	}

}
