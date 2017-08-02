package com.wshop.util;

import java.text.DecimalFormat;

public class NumUtil {

    public static String formateMerchantCode(Integer merchantId) {
        DecimalFormat df = new DecimalFormat("100000");
        return df.format(merchantId.intValue());
    }

    public static String formateStoreCode(String merchantCode,Integer storeId){
        DecimalFormat df = new DecimalFormat("000");
        return merchantCode + df.format(storeId.intValue());
    }

    public static String  formateDeviceCode(Integer posDeviceId) {
        DecimalFormat df = new DecimalFormat("10000000");
        return df.format(posDeviceId.intValue());
    }

}
