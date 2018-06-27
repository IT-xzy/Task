package com.jnshu.exception;

//系统自定义异常处理类,针对预期的异常，需要在程序中抛出此类的异常
public class UserException extends Exception{
    //异常信息
    private String message;

    public UserException(String message){
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
