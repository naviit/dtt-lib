/************************************************
 * Copyright 2018 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.cache;

public class CachableData<T> implements Cachable {

  private volatile long lastAccessedTime;

  private int maxInactiveIntervalInSeconds;

  private T data;

  public CachableData() {}

  public CachableData(T data) {
    this.data = data;
  }

  public CachableData(int maxInactiveIntervalInSeconds, T data) {
    this.data = data;
    this.maxInactiveIntervalInSeconds = maxInactiveIntervalInSeconds;
  }

  public T getData() { return data; }

  public void setLastAccessTime(long lastAccessedTime) { this.lastAccessedTime = lastAccessedTime; }
  public long getLastAccessTime() {  return lastAccessedTime; }

  public int getMaxInactiveIntervalInSeconds() { return maxInactiveIntervalInSeconds; }
  public void setMaxInactiveIntervalInSeconds(int maxInactiveIntervalInSeconds) {
    this.maxInactiveIntervalInSeconds = maxInactiveIntervalInSeconds;
  }

}