package com.deli.echolog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DiaryFeedbackNotFoundException extends RuntimeException{
    public DiaryFeedbackNotFoundException(String message) {
        super(message);
    }
}
