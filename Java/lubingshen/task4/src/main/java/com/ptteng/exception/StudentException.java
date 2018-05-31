package com.ptteng.exception;

public class StudentException extends Exception {
    //异常信息
    private String message;

    public StudentException(String message) {
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
