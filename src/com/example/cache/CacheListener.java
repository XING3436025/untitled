package com.example.cache;

import java.util.Set;


public class CacheListener {
    private Cache cache;

    public CacheListener(Cache cache) {
        this.cache = cache;
    }

    public void startListen() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    Set<String> keys = cache.getKeys();

                    for (String key : keys) {

                        if (cache.isTimeOut(key)) {
                            cache.remove(key);
                            System.out.println(key + " 被清除了");
                    }
                    }

                    try {
                        Thread.sleep(10000);
                        System.out.println("休息10s再检查");
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
