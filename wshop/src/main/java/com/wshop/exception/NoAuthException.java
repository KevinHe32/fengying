/*
 * Copyright(c) 2017 kashuo.net All rights reserved.
 */
package com.wshop.exception;

/**
 * @author dell
 * @Time 2017-03-22 16:36:42
 */
public class NoAuthException extends RuntimeException {
    public NoAuthException() {

    }

    public NoAuthException(String message) {
        super(message);
    }
}
