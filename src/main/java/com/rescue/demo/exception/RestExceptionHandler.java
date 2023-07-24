package com.rescue.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse methodArgumentNotValidException(MethodArgumentNotValidException e) {
        ExceptionResponseBuilder exceptionResponseBuilder = new ExceptionResponseBuilder(
                LocalDateTime.now(),
                "Bad request",
                HttpStatus.BAD_REQUEST.value(),
                "Eita! Algum campo foi preenchido incorretamente!"
        );
        return exceptionResponseBuilder.build();
    }
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse noSuchElementException(NoSuchElementException e){
        ExceptionResponseBuilder exceptionResponseBuilder = new ExceptionResponseBuilder(
                LocalDateTime.now(),
                "Not Found",
                HttpStatus.NOT_FOUND.value(),
                "Não foi encontrada nenhuma arma com o ID fornecido!"
        );
        return exceptionResponseBuilder.build();
    }
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse nullPointerException(NullPointerException e){
        ExceptionResponseBuilder exceptionResponseBuilder = new ExceptionResponseBuilder(
                LocalDateTime.now(),
                "Internal Server Error",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "A requisição falhou porque contem um elemento nulo!"
        );
        return exceptionResponseBuilder.build();
    }
}