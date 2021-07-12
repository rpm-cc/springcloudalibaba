package com.tencent.wework;


import org.bouncycastle.util.encoders.Base64;

/**
 * @Author PimingRen
 * @Date 2021/05/06
 * @Version 1.0
 */
public class Base64Coded {

    /**
     *  base64 解码
     */
    public static String decode(String text) {
        return new String(Base64.decode(text.getBytes()));
    }

    /**
     *  base64 编码
     */
    public static String encode(String text) {
        return new String(Base64.encode(text.getBytes()));
    }

}


