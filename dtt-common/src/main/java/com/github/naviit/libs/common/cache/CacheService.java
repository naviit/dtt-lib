/************************************************
 * Copyright 2018 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class CacheService<T extends Cachable> {

  protected volatile Map<String, T> objects;

  private ExecutorService deleteExecutor;

  private ScheduledExecutorService scheduledExecutor;

  public CacheService() {
    this.objects = new ConcurrentHashMap<String, T>();

    this.deleteExecutor = Executors.newFixedThreadPool(256);

    scheduledExecutor = Executors.newScheduledThreadPool(1);
    scheduledExecutor.scheduleWithFixedDelay(() -> removeExpired(), 10, 1, TimeUnit.SECONDS);
  }

  private void removeExpired() {
    objects.forEach((key, obj) -> {
      if(!obj.isExpired(getMaxInactiveIntervalInSeconds(obj))) return;
      deleteExecutor.execute(() -> objects.remove(key));
    });
  }

  public void put(String key, T obj) {
    if(obj == null || key == null) return;
    objects.put(key, obj);
  }

  public void remove(String key) {
    if(key == null) return;
    objects.remove(key);
  }

  public T get(String key) {
    T obj = objects.get(key);
    if(obj == null) return obj;
    if (obj.isExpired(getMaxInactiveIntervalInSeconds(obj))) {
      deleteExecutor.execute(() -> objects.remove(key));
      return null;
    }
    return obj;
  }

  public abstract int getMaxInactiveIntervalInSeconds(T t);
}