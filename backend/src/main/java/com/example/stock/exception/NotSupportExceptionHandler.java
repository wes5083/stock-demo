package com.example.stock.exception;

import com.example.stock.common.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class NotSupportExceptionHandler {

    @ExceptionHandler(NotSupportException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseVo handleNotSupportException(NotSupportException ex) {
        return new ResponseVo(ex.getCode(), ex.getMessage(), null);
    }

}
