package com.exception;

public class MyException extends Exception {
    public MyException() {
        super("系统错误，请重试");
    }

    public MyException(String errorMessage) {
        super(errorMessage);
    }
}
