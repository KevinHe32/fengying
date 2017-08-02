package com.wshop.test;

import org.apache.shiro.crypto.hash.Md5Hash;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Alan on 2017/7/30.
 */
public class GenerateMD5 {
    public static String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

    public static void test(){
        /*String password_md5 = new Md5Hash("admin").toString();
        System.out.println("md5加密，不加盐="+password_md5);

        //md5加密，加盐，一次散列
        String password_md5_sale_1 = new Md5Hash("admin", "eteokues", 1).toString();
        System.out.println("password_md5_sale_1="+password_md5_sale_1);
        String password_md5_sale_2 = new Md5Hash("admin", "uiwueylm", 1).toString();
        System.out.println("password_md5_sale_2="+password_md5_sale_2);


      */
        String password_md5 = new Md5Hash("111111").toString();
        System.out.println("md5加密，不加盐="+password_md5);
        //md5加密，加盐，一次散列
        String password_md5_sale_1 = new Md5Hash("111111", "eteokues", 1).toString();
        System.out.println("password_md5_sale_1="+password_md5_sale_1);
        String password_md5_sale_2 = new Md5Hash("111111", "uiwueylm", 1).toString();
        System.out.println("password_md5_sale_2="+password_md5_sale_2);
        //两次散列相当于md5(md5())
    }
    public static void main(String[] args){
        try{
            test();
            //System.out.println("====:"+EncoderByMd5("123"));
        }catch (Exception e){

        }

    }
}
