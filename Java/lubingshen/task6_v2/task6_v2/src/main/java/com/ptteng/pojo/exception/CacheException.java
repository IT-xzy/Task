package com.ptteng.pojo.exception;

public class CacheException extends RuntimeException {
    //异常信息
    private String message;

    public CacheException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
