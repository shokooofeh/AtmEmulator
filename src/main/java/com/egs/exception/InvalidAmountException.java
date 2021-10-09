package com.egs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidAmountException extends Exception {
    public InvalidAmountException(String message){
        super(message);
    }
}
