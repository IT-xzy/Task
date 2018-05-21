package com.ptteng.pojo.exception;

/*可能由XSS攻击导致的异常*/
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
