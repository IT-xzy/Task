package com.ptteng.pojo.exception;

public class ServerException extends RuntimeException {
    //异常信息
    private String message;

    public ServerException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;

    }

}
