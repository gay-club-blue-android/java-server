package com.example.bfjavaserver.controllers.shared;

import org.springframework.http.HttpStatus;

/**
 * сущность, позволяющая создавать ошибки для отправки клиенту
 */
public class CustomException extends Exception {
    private HttpStatus httpStatus;
    private String exceptionName;

    public CustomException(String exceptionName, String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
        this.exceptionName = exceptionName;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public static CustomException AuthException(String message) {
        return new CustomException("AuthException", message, HttpStatus.UNAUTHORIZED);
    }

    public static CustomException FatalException(String message) {
        return new CustomException("FatalException", message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static CustomException LogicException(String message) {
        return new CustomException("LogicException", message, HttpStatus.FORBIDDEN);
    }
    public static CustomException BadDataException(String message){
        return new CustomException("BadDataException", message, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @Override
    public String toString() {
        return exceptionName + ":" + getMessage();
    }
}
