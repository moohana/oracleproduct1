package com.stackroute.manualservice.exception;

public class QueryAlreadyExistException extends Exception{

    private String message;

    public QueryAlreadyExistException() {
    }

    public QueryAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }
}
