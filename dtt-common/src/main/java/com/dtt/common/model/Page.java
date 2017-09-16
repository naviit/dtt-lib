/************************************************************************
 * Copyright 2017 by DTT - All rights reserved.                         *    
 ************************************************************************/
package com.dtt.common.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Dang Thanh Tung
 * 		Email: dtt.dangthanhtung@gmail.com
 * Created: 09/07/2017
 */
public class Page<E> {

	private int pageNumber;
	private int pageSize = 10;
	private int pagesAvailable;
	private long totalItems;
	private long time;
	public List<E> pageItems;
	
	public Page() {
		this.pageItems = new ArrayList<E>(10);
	}
	
	public Page(int pageNumber, int pagesAvailable) {
		this.pageNumber = pageNumber;
		this.pagesAvailable = pagesAvailable;
		this.pageItems = new ArrayList<E>(10);
	}
	
	public Page(List<E> all, int pageNumber, int pageSize) {
		this.pageNumber = pageNumber;
		this.pageItems = new ArrayList<E>(pageSize);
		this.computePagesAvailable(all.size(), pageSize);
		
		int start = (pageNumber - 1) * pageSize;
		int end = (int) Math.min(this.totalItems, pageNumber * pageSize);
		if (all.size() <= pageSize) {
			this.pageItems = all;
		} else {
			if(start >= 0 && end > start) this.pageItems.addAll(all.subList(start, end)); 
		}
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
	
	public void computePagesAvailable(long numberOfResults, int size) {
		this.pageSize = size;
		this.totalItems = numberOfResults;
		this.pagesAvailable = 0;
		if(totalItems % pageSize == 0) {
			this.pagesAvailable = (int) (totalItems / pageSize);
		} else {
			this.pagesAvailable = (int) (totalItems / pageSize) + 1;
		}
	}
	
}
