package com.ev.exception;

public class StudentDuplicateException extends Exception{

    private String message;

    public StudentDuplicateException(String message) {
        super(message);
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
