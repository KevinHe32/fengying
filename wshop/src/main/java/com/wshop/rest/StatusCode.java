/*
 * Copyright(c) 2017 kashuo.net All rights reserved.
 */
package com.wshop.rest;

/**
 * @author dell
 * @Time 2017-03-22 16:36:42
 */
public class StatusCode {
    public static final int SUCCESS = 0;
    public static final int ERROR = 1000; //未知错误

    public static final int ERROR_PARAM = 1001; //参数错误
    public static final int ERROR_IDCARD_INVALID = 1301;
    public static final int ERROR_PARTNERKEY_INVALID = 1302;

    public static final int ERROR_INVALID = 2000; //身份证或银行卡认证无效

    public static final int ERROR_APPKEY_INVALID = 2001; //appkey不存在
    public static final int ERROR_SETRETKEY_INVALID = 2002; //secretkey不存在或错误
    public static final int ERROR_TOKEN_INVALID = 2003; //token校验失败


}
