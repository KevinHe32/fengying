package com.wshop.rest;

/**
 * Created by dell on 2017/4/1.
 */
public class CompanyStatusCode {
    public static final int SUCCESS_COMPANY_CENTER = 0;
    public static final int SUCCESS_BRANCH_COMPANY = 1;
    public static final int SUCCESS_DEPARTMENT = 2;

    public static final int ERROR = 1000; //未知错误

    public static final int ERROR_PARAM = 1001; //参数错误
    public static final int ERROR_IDCARD_INVALID = 1301;
    public static final int ERROR_PARTNERKEY_INVALID = 1302;

}
