package com.example.bfjavaserver.controllers.shared;

import com.example.bfjavaserver.dtos.shared.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsController {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionResponseDto> handleException(CustomException e) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(e.toString());
        return new ResponseEntity<>(exceptionResponseDto, e.getHttpStatus());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> handleException(Exception e) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(e.toString());
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.BAD_REQUEST);
    }

    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseDto> handleException(MethodArgumentNotValidException e) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(e.toString() + "    ");
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.BAD_REQUEST);//maybe 403 error
    }*/
}
