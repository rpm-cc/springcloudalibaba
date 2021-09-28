package com.tencent.wework.api.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

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
}
