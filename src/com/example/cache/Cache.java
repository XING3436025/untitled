package com.example.cache;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public interface Cache<T extends Serializable> {

    Collection<String> keys();

    void put(String key, CacheEntity cacheData);


    void put(String key, Object data, Long timeout);

    CacheEntity getCacheByKey(String key);


    Map<String, CacheEntity> getCacheAll();


    boolean isExist(String key);


    void removeAll();

    boolean isTimeOut(String key);


    Set<String> getKeys();

    void remove(String key);

}
