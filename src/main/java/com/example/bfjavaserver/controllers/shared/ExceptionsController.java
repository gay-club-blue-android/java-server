package com.example.bfjavaserver.controllers.shared;

import com.example.bfjavaserver.dtos.shared.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsController {

    @ExceptionHandler(FatalException.class)
    public ResponseEntity<ExceptionResponseDto> handleException(FatalException e) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(e.getMessage());
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(LogicException.class)
    public ResponseEntity<ExceptionResponseDto> handleException(LogicException e) {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(e.getMessage());
        return new ResponseEntity<>(exceptionResponseDto, HttpStatus.BAD_REQUEST);//maybe 403 error
    }

    //for plain exception class

}
