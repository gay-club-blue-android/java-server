package com.example.bfjavaserver.controllers.shared;

public class FatalException extends Exception{
    public FatalException(String message) {
        super(message);
    }
}
