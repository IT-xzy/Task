package com.artist.service;

public class ApplicationException extends RuntimeException {
    public ApplicationException() {
    }
    ApplicationException(String message) {
        super(message);
    }
}
