package com.fastcampus.ordersystem.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value =RuntimeException.class)
    public Response<Void> handleRuntimeException(RuntimeException e) {
        return Response.fail(e.getMessage()); // runtime exception 이 발생하면 fail 메시지를 반환한다.
    }
}
