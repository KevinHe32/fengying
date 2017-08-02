/*
 * Copyright(c) 2017 kashuo.net All rights reserved.
 */
package com.wshop.rest;


import com.wshop.exception.NotFoundException;

/**
 * @author dell
 * @Time 2017-03-22 16:36:42
 */
public class HttpAssert {

    public static void notFound(Object object) {
        if(object == null) {
            throw new NotFoundException("[Assertion failed] - this argument is required; it must not be null");
        }
    }
    
    public static void notFound(Object object, String message) {
        if(object == null) {
            throw new NotFoundException(message);
        }
    }
}
