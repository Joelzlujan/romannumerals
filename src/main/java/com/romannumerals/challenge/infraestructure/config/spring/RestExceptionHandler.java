package com.romannumerals.challenge.infraestructure.config.spring;

import com.romannumerals.challenge.application.exception.RomanNumeralException;
import com.romannumerals.challenge.infraestructure.rest.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    private static final String INVALID_ARGUMENT = "Argumentos inválidos.";

    private static ErrorResponse buildErrorResponse(HttpStatus httpStatus, String message,
                                                    Exception e) {
        return new ErrorResponse(httpStatus.value(), message, e.getMessage());
    }

    @ExceptionHandler(value = RomanNumeralException.class)
    protected ResponseEntity<ErrorResponse> handleRomanNumeralException(RomanNumeralException e) {
        ErrorResponse errorResponse = buildErrorResponse(HttpStatus.BAD_REQUEST, INVALID_ARGUMENT, e);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}