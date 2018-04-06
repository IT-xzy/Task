package com.ptteng.pojo.exception;

/*可能由XSS攻击导致的异常*/
public class ForbiddenException extends RuntimeException {
    //异常信息
    private String message;

    public ForbiddenException(String message) {
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
