package com.flairstech.task.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CountryWithCodeNotExsist extends RuntimeException {
    public CountryWithCodeNotExsist(String msg) {
        super(msg);
    }
}
