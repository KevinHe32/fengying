/*
 * Copyright(c) 2017 kashuo.net All rights reserved.
 */
package com.wshop.rest;

/**
 * @author dell
 * @Time 2017-03-22 16:36:42
 */
public abstract class AbstractResult {
    private int code;
    private String message;

    public AbstractResult(int code) {
        this.code = code;
    }

    public AbstractResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
