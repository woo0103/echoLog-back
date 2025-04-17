package com.deli.echolog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TransformDiaryNotFoundException extends RuntimeException {
    public TransformDiaryNotFoundException(String message) {
        super(message);
    }
}
