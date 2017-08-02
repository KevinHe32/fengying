/*
 * Copyright(c) 2017 kashuo.net All rights reserved.
 */
package com.wshop.rest;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> extends AbstractResult {
    private T data; //单个数据

    @SuppressWarnings(value = "unchecked")
    public static <T> Result<T> ok() {
        return new Result(0, null);
    }

    @SuppressWarnings(value = "unchecked")
    public static <T> Result<T> ok(int code, String message) {
        return new Result(code, message);
    }

    @SuppressWarnings(value = "unchecked")
    public static <T> Result<T> error() {
        return new Result(1, null);
    }

    @SuppressWarnings(value = "unchecked")
    public static <T> Result<T> error(int code, String message) {
        return new Result(code, message);
    }


    public Result() {
        this(0, null);
    }


    public Result(int code, String message) {
        super(code, message);
    }

    public static <T> Result<T> one(T obj) {
        Result<T> res = new Result(0, null);
        res.data = obj;
        return res;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
