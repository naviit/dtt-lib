/************************************************
 * Copyright 2018 by DTT - All rights reserved. *    
 ************************************************/
package com.github.naviit.libs.common.cache;

import java.util.concurrent.TimeUnit;

public interface Cachable {

  public default boolean isExpired(int maxInactiveIntervalInSeconds) {
    return isExpired(System.currentTimeMillis(), maxInactiveIntervalInSeconds);
  }

  public default boolean isExpired(long now, int maxInactiveIntervalInSeconds) {
    if (maxInactiveIntervalInSeconds < 0) return false;
    return now - TimeUnit.SECONDS.toMillis(maxInactiveIntervalInSeconds) >= getLastAccessTime();
  }

  public void setLastAccessTime(long lastAccessedTime);

  public long getLastAccessTime();

  //public int getMaxInactiveIntervalInSeconds();

}
