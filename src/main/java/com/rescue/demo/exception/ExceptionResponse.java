package com.rescue.demo.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionResponse {
    private LocalDateTime timestamp;
    private String status;
    private Integer statusCode;
    private String error;
}