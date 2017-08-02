package com.wshop.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Token工具类
 * Created by Mr.ZHAO on 2016/5/27.
 */
public class TokenUtils {

    private static final String TIME_FORMAT = "yyyyMMddHHmmss";

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(TIME_FORMAT);

    /**
     * 获取当前时间字串：yyyyMMddHHmmss
     */
    public static String currentTimeString() {
        return SIMPLE_DATE_FORMAT.format(new Date());
    }

    public static String encrypt(String appKey, String secretKey) {
        return encrypt(appKey, currentTimeString(), secretKey);
    }

    public static String encrypt(String appKey, String curtime, String secretKey) {
        String token = appKey + curtime + secretKey;
        return EncryptUtils.encryptMD5(token);
    }
}