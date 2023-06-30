package com.example.exhibitioncalendar.controllers;

import com.example.exhibitioncalendar.services.exceptions.NotEnoughMoneyException;
import com.example.exhibitioncalendar.services.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExhibitionCalendarExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiErrorInfo> handleNotFoundException(NotFoundException ex) {
        ApiErrorInfo errorInfo = ApiErrorInfo.builder()
                .title(ex.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<>(errorInfo, errorInfo.getStatus());
    }

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ApiErrorInfo> handleNotEnoughMoneyException(NotEnoughMoneyException ex) {
        ApiErrorInfo errorInfo = ApiErrorInfo.builder()
                .title(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST)
                .build();

        return new ResponseEntity<>(errorInfo, errorInfo.getStatus());
    }
}
