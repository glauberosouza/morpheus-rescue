package com.rescue.demo.exception;

import java.time.LocalDateTime;

public class ExceptionResponseBuilder {
    private LocalDateTime timestamp;
    private String status;
    private Integer statusCode;
    private String error;

    public ExceptionResponseBuilder(LocalDateTime timestamp, String status, int statusCode, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.statusCode = statusCode;
        this.error = error;
    }
    public ExceptionResponse build(){
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setTimestamp(this.timestamp);
        exceptionResponse.setStatus(this.status);
        exceptionResponse.setStatusCode(this.statusCode);
        exceptionResponse.setError(this.error);
        return exceptionResponse;
    }
}