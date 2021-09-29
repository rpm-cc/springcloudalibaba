package com.tencent.wework.api.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import lombok.Data;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/9/28 17:38
 * @version: 1.0
 * @description:
 */
@Data
public class JsonDemo {

    String chat_id;
    @JSONField(name = "chat_group")
    String chatGroup;


    public static void main(String[] args) {
        JsonDemo demo = new JsonDemo();
        demo.setChat_id("111");
        demo.setChatGroup("222");
        String json = JSON.toJSONString(demo);

        JsonDemo jsonDemo = JSON.parseObject(json,JsonDemo.class);
        System.out.println(jsonDemo);


    }


    public static void resttemp(){

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(5000);
        factory.setReadTimeout(3000);
        RestTemplate restTemplate = new RestTemplate(factory);
        //HttpMessageConverter
        FastJsonHttpMessageConverter messageConverter = new FastJsonHttpMessageConverter();

        restTemplate.setMessageConverters(Arrays.asList(messageConverter));
    }
}
