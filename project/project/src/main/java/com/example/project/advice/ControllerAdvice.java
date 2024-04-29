package com.example.project.advice;

import com.example.project.dtos.ErrorDto;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDto> HandleNullPointerException(){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("something went wrong, try again. ");
        ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(errorDto, HttpStatusCode.valueOf(404));
        return responseEntity;
    }
}
