package com.example.cache;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class CacheImpl implements Cache {


    @Override
    public Collection<String> keys() {
        return null;
    }

    private static volatile CacheImpl INSTANCE;

    private static Map<String, CacheEntity> caches = new ConcurrentHashMap<>();

    private  CacheImpl() {
    }

    public static CacheImpl getInstance() {
        if (INSTANCE == null) {
            synchronized (CacheImpl.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CacheImpl();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void put(String key, CacheEntity cacheData) {
        caches.put(key, cacheData);
    }

    @Override
    public void put(String key, Object data, Long timeout) {
        timeout = timeout > 0? timeout : 0L;
        put(key, new CacheEntity(data, timeout, System.currentTimeMillis()));
    }

    @Override
    public CacheEntity getCacheByKey(String key) {
        if(this.isExist(key))
            return caches.get(key);
        return null;
    }

    @Override
    public Map<String, CacheEntity> getCacheAll() {
        return caches;
    }

    @Override
    public boolean isExist(String key) {
        return caches.containsKey(key);
    }

    @Override
    public void removeAll() {
        caches.clear();
    }

    @Override
    public void remove(String key) {
        if (this.isExist(key)) {
            caches.remove(key);
        }
    }

    @Override
    public boolean isTimeOut(String key) {
        if (!this.isExist(key)) {
            return true;
        }

        CacheEntity cacheEntity = caches.get(key);
        Long timeOut = cacheEntity.getTimeout();
        Long initialTime = cacheEntity.getInitialTime();

        if (timeOut == 0 || System.currentTimeMillis() - initialTime < timeOut) {
            return false;
        }
        return true;

    }

    @Override
    public Set<String> getKeys() {
        return caches.keySet();
    }


}
