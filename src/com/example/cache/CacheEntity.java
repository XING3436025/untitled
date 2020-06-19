package com.example.cache;

public class CacheEntity {
    private Object data;


    private Long timeout;

    private Long initialTime;

    public CacheEntity() {
    }

    public CacheEntity(Object data, Long timeout, Long initialTime) {
        this.data = data;
        this.timeout = timeout;
        this.initialTime = initialTime;
    }

    public Object getData() {
        return data;
    }

    public Long getTimeout() {
        return timeout;
    }

    public Long getInitialTime() {
        return initialTime;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public void setInitialTime(Long initialTime) {
        this.initialTime = initialTime;
    }
}
