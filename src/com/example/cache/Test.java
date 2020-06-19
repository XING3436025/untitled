package com.example.cache;


import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        Cache cache = CacheImpl.getInstance();
        cache.put("testtimeout", "kkkkkkkkk", 20 * 1000L);
        cache.put("test1", "111111111", 0L);
        cache.put("test2", "222222222222222", 100 * 1000L);
        cache.put("test3", "33333333333333", 0L);
        CacheListener cacheListener = new CacheListener(cache);
        cacheListener.startListen();

        System.out.println("getCacheAll : " + Arrays.asList(cache.getCacheAll()));
        System.out.println("getCacheKeyAll : " + Arrays.asList(cache.getKeys()));
        System.out.println("getKey : " + Arrays.asList(cache.getCacheByKey("test1")));
        System.out.println("test isExist false: " + Arrays.asList(cache.isExist("test")));
        System.out.println("test1 isExist true: " + Arrays.asList(cache.isExist("test1")));
        System.out.println("istimeOut false: " + Arrays.asList(cache.isTimeOut("test1")));

        System.out.println("------------------测试remove(testtimeout)-------------------------");
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //cache.remove("testtimeout");
        System.out.println("testtimeout isExist : " + Arrays.asList(cache.isExist("testtimeout")));

        System.out.println("------------------测试removeall()---------------------------------");
        cache.removeAll();
        System.out.println("test1 isExist : " + Arrays.asList(cache.isExist("test1")));
        System.out.println("test2 isExist : " + Arrays.asList(cache.isExist("test2")));
        System.out.println("test3 isExist : " + Arrays.asList(cache.isExist("test3")));
    }
}
