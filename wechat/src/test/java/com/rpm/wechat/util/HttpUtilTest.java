package com.rpm.wechat.util;

import com.alibaba.fastjson.JSON;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: Piming Ren
 * @date: 2021/6/25 16:34
 * @version: 1.0
 * @description:
 */
class HttpUtilTest {
    public static void main(String[] args) {

        //System.out.println(testJson());
        System.out.println(testForm());
//        System.out.println(testGet());

    }

    static String testForm(){
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("dir","1611298729335f3As7kgiJ8.mp4"));
        String url  = "http://toujiao.zfxf.com/admin/api/upload/getSt";
        List<Header> headers  = new ArrayList<>();
        headers.add(new BasicHeader("authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiYXVkIjoicWlhb3dlaXlhIiwiZXhwIjoxNjExOTA3MDkzLCJpYXQiOjE2MTEzMDIyOTN9.HTS7p8YN5WHBUfl3D40ZozUGhYrPRGStKHaTRe0H0Rj57Cw1SMrSHfbWaGOWPrYAGmBcf2iA1c_m2GR7wszSOQ"));
        return  HttpUtil.formPost(url,params,headers);

    }
    static  String testJson(){
        Map params = new HashMap<>();
        params.put("dir","1611298729335f3As7kgiJ8.mp4");
        String url  = "http://toujiao.zfxf.com/admin/api/upload/transVideoMp4";
        List<Header> headers  = new ArrayList<>();
        headers.add(new BasicHeader("authorization","Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIyIiwiYXVkIjoicWlhb3dlaXlhIiwiZXhwIjoxNjExOTA3MDkzLCJpYXQiOjE2MTEzMDIyOTN9.HTS7p8YN5WHBUfl3D40ZozUGhYrPRGStKHaTRe0H0Rj57Cw1SMrSHfbWaGOWPrYAGmBcf2iA1c_m2GR7wszSOQ"));
        return  HttpUtil.jsonPost(url, JSON.toJSONString(params),headers);

    }

    static  String testGet(){
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("grant_type","client_credential"));
        params.add(new BasicNameValuePair("appid","wxc71d0efbf1b7053a"));
        params.add(new BasicNameValuePair("secret","d669dc923496e679ee8fbf12968e6709"));
        String url  = "https://api.weixin.qq.com/cgi-bin/token";
        return  HttpUtil.formPost(url,params,null);

    }

}