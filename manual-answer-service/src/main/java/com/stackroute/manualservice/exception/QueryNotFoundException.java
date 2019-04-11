package com.stackroute.manualservice.exception;

public class QueryNotFoundException extends Exception {

    private String message;

    public QueryNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public QueryNotFoundException() {
    }
}
