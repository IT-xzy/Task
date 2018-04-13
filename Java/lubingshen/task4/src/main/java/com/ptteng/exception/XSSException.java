package com.ptteng.exception;

public class XSSException extends Exception {
    //异常信息
    private String message;

    public XSSException(String message) {
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
