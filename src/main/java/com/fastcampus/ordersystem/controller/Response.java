package com.fastcampus.ordersystem.controller;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.net.http.HttpClient;

@Getter
public class Response<T> {
    private final HttpStatus statusCode;
    private final String message;
    private final T data;

    public Response(HttpStatus statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }


    public static <T> Response<T> success(T data) {
        return new Response<>(HttpStatus.OK, "success", data);// 200 코드 제공
    }
    public static <T> Response<T> fail(String errorMessage) {
        return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage , null);// 200 코드 제공
    }
}
