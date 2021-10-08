package com.tencent.wework.api.domain.response.external.employee;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.wework.api.domain.response.WeWorkResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: Piming Ren
 * @date: 2021/9/29 17:34
 * @version: 1.0
 * @description:
 */
@Data
public class ListContactWayResponse extends WeWorkResponse implements Serializable {


    private static final long serialVersionUID = 696799908137562472L;


    /**
     * 此处文档有问题 。返回的key 时contactway 不是文档上写contact_way
     */
    @JSONField(name="contactway")
    List<ConfigId> contactWay;
    @JSONField(name = "next_cursor")
    private String nextCursor;

    @Data
    public static class ConfigId{
        @JSONField(name = "config_id")
        private String configId;
    }



}
