package com.example.stock.exception;


import com.example.stock.common.Constants;
import com.example.stock.common.ResponseStatusCode;
import lombok.Data;

@Data
public class NotSupportException extends RuntimeException {

    private Integer code;

    private String message;

    public NotSupportException(String message) {
        super(message + Constants.SEPARATOR_COMMA_DASH + ResponseStatusCode.NOTSUPPORT.getDescription());
        this.message = message + Constants.SEPARATOR_COMMA_DASH + ResponseStatusCode.NOTSUPPORT.getDescription();
        this.code = ResponseStatusCode.NOTSUPPORT.getValue();
    }

}
