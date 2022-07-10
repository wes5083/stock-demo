package com.example.stock.common;


import lombok.Data;

@Data
public class ResponseVo<T> {

    private int statusCode;

    private String message;

    private T data;

    public ResponseVo(int statusCode, String message, T data) {
        this.message = message;
        this.statusCode = statusCode;
        this.data = data;
    }

    public static <T> ResponseVo<T> success(T data) {
        return new ResponseVo<T>(ResponseStatusCode.SUCCESS.getValue(), ResponseStatusCode.SUCCESS.getDescription(), data);
    }

    public static <T> ResponseVo<T> fail(String message, T data) {
        return new ResponseVo<T>(ResponseStatusCode.FAIL.getValue(), message, data);
    }

}
