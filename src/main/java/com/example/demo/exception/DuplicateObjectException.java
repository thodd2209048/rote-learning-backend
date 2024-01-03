package com.example.demo.exception;

import com.example.demo.exception.base.BaseException;
import org.springframework.http.HttpStatus;

public class DuplicateObjectException extends BaseException {
    public DuplicateObjectException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}