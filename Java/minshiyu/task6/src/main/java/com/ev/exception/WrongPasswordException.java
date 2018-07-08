package com.ev.exception;

public class WrongPasswordException extends Exception {
    private String message;

    public WrongPasswordException(String message) {
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

