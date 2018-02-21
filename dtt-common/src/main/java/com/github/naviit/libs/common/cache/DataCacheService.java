/************************************************
 * Copyright 2018 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.cache;

public class DataCacheService<T> extends CacheService<CachableData<T>> {

  private int maxInactiveIntervalInSeconds;

  public DataCacheService(int maxInactiveIntervalInSeconds) {
    this.maxInactiveIntervalInSeconds = maxInactiveIntervalInSeconds;
  }

  public void put(String key, T data) {
    super.put(key, new CachableData<T>(data));
  }

  public T getByKey(String key){
    CachableData<T> data = get(key);
    if(data == null) return null;
    return data.getData();
  }

  @SuppressWarnings("unused")
  public int getMaxInactiveIntervalInSeconds(CachableData<T> data) { return maxInactiveIntervalInSeconds; }

}