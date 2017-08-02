/*
 * Copyright(c) 2017 kashuo.net All rights reserved.
 */
package com.wshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author dell
 * @Time 2017-03-22 16:36:42
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Resource not fount")
public class NotFoundException extends RuntimeException {
    public NotFoundException() {

    }

    public NotFoundException(String message) {
        super(message);
    }
}
