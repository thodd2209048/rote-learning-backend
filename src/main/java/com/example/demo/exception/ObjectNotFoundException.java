package com.example.demo.exception;

import com.example.demo.exception.base.BaseException;
import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends BaseException {

    public ObjectNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
